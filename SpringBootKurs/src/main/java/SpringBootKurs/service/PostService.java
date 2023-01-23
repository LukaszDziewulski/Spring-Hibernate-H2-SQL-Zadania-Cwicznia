package SpringBootKurs.service;

import SpringBootKurs.model.Comment;
import SpringBootKurs.model.Post;
import SpringBootKurs.repository.CommentRepository;
import SpringBootKurs.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPost(PageRequest.of(page, PAGE_SIZE,   // stronicowanie
                Sort.by(sort,"id")));  // sortowanie
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}
