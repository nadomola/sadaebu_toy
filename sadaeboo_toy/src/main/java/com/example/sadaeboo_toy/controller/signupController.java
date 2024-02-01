package com.example.sadaeboo_toy.controller;

import com.example.sadaeboo_toy.dto.userdto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class signupController {
    @GetMapping("/signup") // url 요청 접수
    public String signUp(userdto form){ //폼데이터를 dto로 받기
        System.out.println(form.toString()); // dto에 폼데이터가 잘 담겼는지 확인
        return "signUpTest";
    }



}
