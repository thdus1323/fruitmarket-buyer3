package com.example.fruitmarketbuyer3.buyer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BuyerRespository {
    private final EntityManager em;

    //1. 회원가입
//    public void join(BuyerRequest.JoinDTO reqDTO) {
//        Query query = em.createQuery("insert into buyer_tb(buyer_name, buyer_pw, buyer_email, created_at) values (?,?,?, now())");
//        query.setParameter(1, reqDTO.getBuyerName());
//        query.setParameter(2, reqDTO.getBuyerPw());
//        query.setParameter(3, reqDTO.getBuyerEmail());
//        query.executeUpdate();
//    }

    //1. 회원가입_jpql
    @Transactional
    public Buyer save(Buyer buyer){
        em.persist(buyer);
        return buyer;
    }


    //2. 로그인
    public Buyer login(BuyerRequest.LoginDTO reqDTO) {
        Query query = em.createQuery("select b from Buyer b where b.buyerName = :name AND b.buyerPw = :password", Buyer.class);
        query.setParameter("name", reqDTO.getBuyerName());
        query.setParameter("password", reqDTO.getBuyerPw());
        return (Buyer) query.getSingleResult();
    }

}
