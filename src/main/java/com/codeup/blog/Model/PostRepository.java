package com.codeup.blog.Model;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    Post findByBody(String body);
    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
//    @Query("from Post a where a.id like ?1")
//    Post getAdById(long id);
//
//    // The following method shows you how to use named parameters in a HQL custom query:
//    @Query("from Post a where a.title like %:term%")
//    List<Post> searchByTitleLike(@Param("term") String term);
}
