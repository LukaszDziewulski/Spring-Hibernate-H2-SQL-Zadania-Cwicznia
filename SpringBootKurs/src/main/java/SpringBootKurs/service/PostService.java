package SpringBootKurs.service;

import SpringBootKurs.model.Post;
import SpringBootKurs.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final static int PAGE_SIZE = 1;  //jeden na strone
    private final PostRepository postRepository;

    public List<Post> getPost(int page) {
        return postRepository.findAllPost(PageRequest.of(page,PAGE_SIZE)); // stronicowanie
    }

    public Post getSinglePost(long id){
        return postRepository.findById(id)
                .orElseThrow();
    }
}
