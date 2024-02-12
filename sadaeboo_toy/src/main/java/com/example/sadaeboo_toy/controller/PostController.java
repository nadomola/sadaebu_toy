package com.example.sadaeboo_toy.controller;

import com.example.sadaeboo_toy.entity.Post;
import com.example.sadaeboo_toy.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j // 로깅 위한 어노테이션 추가
@RestController //REST API용 컨트롤러
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    //모든 게시글 조회
    @GetMapping
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    //특정 id의 게시글 조회
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow(()-> new RuntimeException("게시글을 찾을 수 없습니다. ID : "+ id));
    }

    //새로운 게시글 작성
    @PostMapping
   public Post createPost (@RequestBody Post post){
        return postRepository.save(post);
    }

    //특정 id의 게시글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Post> partiallyUpdatePost(@PathVariable Long id, @RequestBody Post updatedPost){
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            //내용이 주어진 경우에만 업데이트 -> 아이디는 수정 불 가
            if(updatedPost.getContent() != null){
                existingPost.setContent(updatedPost.getContent());
            }
            postRepository.save(existingPost);
            return ResponseEntity.ok(existingPost);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    //특정 id의 게시글 삭제
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
    }

}
