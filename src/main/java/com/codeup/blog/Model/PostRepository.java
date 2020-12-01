package com.codeup.blog.Model;

import com.codeup.blog.Post;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    Post findByFirstTitle(String title);

    Post findByid(Long id);

    Post findByBody(String body);
}
