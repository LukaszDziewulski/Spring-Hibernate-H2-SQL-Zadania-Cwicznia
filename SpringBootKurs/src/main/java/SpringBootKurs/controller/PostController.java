package SpringBootKurs.controller;

import SpringBootKurs.controller.dto.PostDto;
import SpringBootKurs.controller.dto.PostDtoMapper;
import SpringBootKurs.model.Post;
import SpringBootKurs.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPost(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0; // nie bedzie ujemnych - zabezpieczenie
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.mapToPostDtos(postService.getPost(pageNumber, sortDirection));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostWithComments(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0; // nie bedzie ujemnych - zabezpieczenie
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostWithComments(pageNumber, sortDirection);
    }


    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable Long id) {
        return postService.getSinglePost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
