package com.example.sadaeboo_toy.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // toString 어노테이션이 포함 되어 있음 ! getter,setter도 !
@AllArgsConstructor //새 어노테이션 추가 ? ( 내가 만든 객체에 대한 생성자가 자동으로 만들어짐 )
@NoArgsConstructor //기본 생성자 추가 어노테이션
public class userdto {
    @Id // 엔티티의 대푯값 지정
    @GeneratedValue //자동 기능 추가 (숫자가 자동으로 매겨짐 )
    private Long token;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private String id;
    @Column
    private String password;
    @Column
    private String birthday;
    @Column
    private Long phonenum;


}
