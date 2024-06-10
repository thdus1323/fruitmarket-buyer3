package com.example.fruitmarketbuyer3.buyer;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BuyerController {
    private final BuyerService buyerService;
    private final HttpSession session;

    //1. 회원가입
    // TODO: reqDTO에 값 검증 (buyerName - null(공백포함), 20자, pw - null, email - null)
    @PostMapping("/join")
    public String join(BuyerRequest.JoinDTO reqDTO){

        if(reqDTO.getBuyerName() == null || reqDTO.getBuyerName().isEmpty()){
            throw new RuntimeException("이름이 null일 수 없어요");
        }

        if (reqDTO.getBuyerName().length() > 20){
            throw new RuntimeException("이름은 20자 이하여야만 해요.");
        }

        if (reqDTO.getBuyerPw() == null || reqDTO.getBuyerPw().isEmpty()){
            throw new RuntimeException("pw가 null일 수 없어요");
        }

        if (reqDTO.getBuyerEmail() == null || reqDTO.getBuyerEmail().isEmpty()){
            throw new RuntimeException("email이 null일 수 없어요");
        }

        buyerService.join(reqDTO);
        return "redirect:/login-form";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "buyer/join-form";
    }

    //2. 로그인
    @PostMapping("/login")
    public String login(BuyerRequest.LoginDTO reqDTO){

        if(reqDTO.getBuyerName() == null || reqDTO.getBuyerName().isEmpty()){
            throw new RuntimeException("이름이 null일 수 없어요");
        }

        if (reqDTO.getBuyerName().length() > 20){
            throw new RuntimeException("이름은 20자 이하여야만 해요.");
        }

        if (reqDTO.getBuyerPw() == null || reqDTO.getBuyerPw().isEmpty()){
            throw new RuntimeException("pw가 null일 수 없어요");
        }

        Buyer sessionBuyer = buyerService.login(reqDTO);
        session.setAttribute("sessionBuyer", sessionBuyer);
        return "redirect:/";
    }

    @GetMapping("/login-form")
    public String loginForm(){
        return "/buyer/login-form";
    }
}
