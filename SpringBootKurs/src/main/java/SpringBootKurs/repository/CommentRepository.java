package SpringBootKurs.repository;

import SpringBootKurs.model.Comment;
import SpringBootKurs.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPostIdIn(List<Long> ids);
}
