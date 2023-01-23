package SpringBootKurs.service;

import SpringBootKurs.model.Post;
import SpringBootKurs.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPost() {
        return postRepository.findAll();
    }

    public Post getSinglePost(long id){
        return postRepository.findById(id)
                .orElseThrow();
    }
}
