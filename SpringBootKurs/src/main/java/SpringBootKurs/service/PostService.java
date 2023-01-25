package SpringBootKurs.service;

import SpringBootKurs.model.Comment;
import SpringBootKurs.model.Post;
import SpringBootKurs.repository.CommentRepository;
import SpringBootKurs.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final static int PAGE_SIZE = 2;  //jeden na strone
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPost(int page, Sort.Direction sort) {
        return postRepository.findAllPost(
                PageRequest.of(page, PAGE_SIZE,   // stronicowanie
                        Sort.by(sort, "id"))); // sortowanie
    }

    @Cacheable(cacheNames = "SinglePost", key = "#id")
    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    @Cacheable(cacheNames = "PostWithComments")
    public List<Post> getPostWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPost(PageRequest.of(page, PAGE_SIZE,   // stronicowanie
                Sort.by(sort, "id")));  // sortowanie
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, Long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    @CachePut(cacheNames = "SinglePost", key = "#result")   // edytuje dane w cache automatycznie przeładowane na nowe
    public Post editPost(Post post) {
        Post postEdited = postRepository.findById(post.getId()).orElseThrow();
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postEdited;
    }

    @CacheEvict(cacheNames = "SinglePost") // automatyczne usuniecie z cache posta po wykonaniu deleta
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
