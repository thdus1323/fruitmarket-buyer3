package com.example.fruitmarketbuyer3.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final HttpSession session;
    private final UserService userService;

    //1. 회원가입
    // TODO: reqDTO에 값 검증 (buyerName - null(공백포함), 20자, pw - null, email - null)
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO reqDTO){

        if(reqDTO.getUserName() == null || reqDTO.getUserName().isEmpty()){
            throw new RuntimeException("이름이 null일 수 없어요");
        }

        if (reqDTO.getUserName().length() > 20){
            throw new RuntimeException("이름은 20자 이하여야만 해요.");
        }

        if (reqDTO.getUserPw() == null || reqDTO.getUserPw().isEmpty()){
            throw new RuntimeException("pw가 null일 수 없어요");
        }

        if (reqDTO.getUserEmail() == null || reqDTO.getUserEmail().isEmpty()){
            throw new RuntimeException("email이 null일 수 없어요");
        }

        if (reqDTO.getRole() == null || reqDTO.getRole().isEmpty()){
            throw new RuntimeException("role를 선택해주세요");
        }

        userService.join(reqDTO);
        return "redirect:/login-form";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "user/join-form";
    }

    //2. 로그인
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO){

        if(reqDTO.getUserName() == null || reqDTO.getUserName().isEmpty()){
            throw new RuntimeException("이름이 null일 수 없어요");
        }

        if (reqDTO.getUserName().length() > 20){
            throw new RuntimeException("이름은 20자 이하여야만 해요.");
        }

        if (reqDTO.getUserPw() == null || reqDTO.getUserPw().isEmpty()){
            throw new RuntimeException("pw가 null일 수 없어요");
        }

        if (reqDTO.getRole() == null || reqDTO.getRole().isEmpty()){
            throw new RuntimeException("role를 선택해주세요");
        }

        User sessionUser = userService.login(reqDTO);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    @GetMapping("/login-form")
    public String loginForm(){
        return "/user/login-form";
    }

    @GetMapping("/logout")
    public String logout(){
        return "/user/login-form";
    }
}
