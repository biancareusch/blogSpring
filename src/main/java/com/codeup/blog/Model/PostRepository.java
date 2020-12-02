package com.codeup.blog.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    Post findByBody(String body);
//    Post deletePostByID(long id);

//
//    @Query("update posts p set p.title = :title, p.body = :body where p.id like ? 1")
//    void editPost(@Param("title")String title,@Param("body") String body, long id);

//    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from Post a where a.title like %:term%")
//    List<Post> searchByTitleLike(@Param("term") String term);
}
