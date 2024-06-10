package com.example.fruitmarketbuyer3.buyer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BuyerService {
    private final BuyerRespository buyerRespository;

    //1. 회원가입
    @Transactional
    public void join(BuyerRequest.JoinDTO reqDTO){
//        Buyer buyer = new Buyer();
//        buyer.setBuyerName(reqDTO.getBuyerName());
//        buyer.setBuyerPw(reqDTO.getBuyerPw());
//        buyer.setBuyerEmail(reqDTO.getBuyerEmail());
//        buyer.setCreatedAt(LocalDateTime.now());

        buyerRespository.save(reqDTO.toEntity());
    }

    //2. 로그인
    // 1) 네임 pw가 db에 있는지 조회하기
    // 2) 조회된 결과 buyer 객체를 session에 담아야 됨.
    // 3) session에 담는 것은 service의 책임이 아님.
    // 4) session 관련된 일은 controller의 책임이다.
    // 5) buyer객체를 return 해야 겠군.
    public Buyer login(BuyerRequest.LoginDTO reqDTO){
        Buyer sessionBuyer = buyerRespository.login(reqDTO);
        return sessionBuyer;
    }
}
