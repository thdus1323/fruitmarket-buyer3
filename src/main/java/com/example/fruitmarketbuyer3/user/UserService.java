package com.example.fruitmarketbuyer3.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRespository userRespository;

    //1. 회원가입
    @Transactional
    public void join(UserRequest.JoinDTO reqDTO){
//        Buyer buyer = new Buyer();
//        buyer.setBuyerName(reqDTO.getBuyerName());
//        buyer.setBuyerPw(reqDTO.getBuyerPw());
//        buyer.setBuyerEmail(reqDTO.getBuyerEmail());
//        buyer.setCreatedAt(LocalDateTime.now());

        // TODO: username 못들어오게 중복 회원가입 안되게 막기

        //db가져오고 그 값이랑 reqdto랑 비교해서 있는 있으면 throw로 중복네임이라고하라!

//        String reqUsername = reqDTO.getUserName();
//
//        User presentUser = userRespository.login(reqUsername).orElse(null);
//        if(presentUser != null){throw new RuntimeException()"이름 중복이여요"}
        userRespository.save(reqDTO.toEntity());
    }

    //2. 로그인
    // 1) 네임 pw가 db에 있는지 조회하기
    // 2) 조회된 결과 buyer 객체를 session에 담아야 됨.
    // 3) session에 담는 것은 service의 책임이 아님.
    // 4) session 관련된 일은 controller의 책임이다.
    // 5) buyer객체를 return 해야 겠군.
    public User login(UserRequest.LoginDTO reqDTO){
        User sessionUser = userRespository.login(reqDTO);
        return sessionUser;
    }
}
