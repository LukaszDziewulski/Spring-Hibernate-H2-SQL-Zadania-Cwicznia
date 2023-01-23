package SpringBootKurs.controller;

import SpringBootKurs.controller.dto.PostDto;
import SpringBootKurs.controller.dto.PostDtoMapper;
import SpringBootKurs.model.Post;
import SpringBootKurs.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/posts")
    public List<PostDto> getPost(@RequestParam(required = false) int page) {
        int pageNumber = page >= 0 ? page : 0; // nie bedzie ujemnych - zabezpieczenie
        return PostDtoMapper.mapToPostDtos(postService.getPost(pageNumber));
    }



    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);
    }

}
