package com.example.fruitmarketbuyer3.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRespository {
    private final EntityManager em;

    //1. 회원가입_jpql
    @Transactional
    public User save(User user){
        em.persist(user);
        return user;
    }


    //2. 로그인
    public User login(UserRequest.LoginDTO reqDTO) {
        Query query = em.createQuery("select b from User b where b.userName = :name AND b.userPw = :password AND b.role = :role", User.class);
        query.setParameter("name", reqDTO.getUserName());
        query.setParameter("password", reqDTO.getUserPw());
        query.setParameter("role", reqDTO.getRole());
        return (User) query.getSingleResult();
    }

}
