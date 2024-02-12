package com.example.sadaeboo_toy.repository;

import com.example.sadaeboo_toy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long > {

}
