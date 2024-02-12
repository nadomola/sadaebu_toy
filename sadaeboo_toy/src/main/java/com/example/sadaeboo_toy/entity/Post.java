package com.example.sadaeboo_toy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor //Post 생성자를 대체하는 어노테이션 추가
@ToString //ToString 메서드를 대체하는 어노테이션 추가
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String postId;
    @Column
    private String content;
    @Column
    private String imageUrl; //이미지 url을 저장할 필드 추가
    //이미지 url 설정 메서드
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    //이미지 url 조회 메서드
    public String getImageUrl(){
        return imageUrl;
    }

}
