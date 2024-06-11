package com.example.fruitmarketbuyer3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO{
        private String userName;
        private String userPw;
        private String userEmail;

        public User toEntity(){
            User user = User.builder()
                    .userName(userName)
                    .userPw(userPw)
                    .userEmail(userEmail)
                    .build();
//            buyer.setBuyerName(buyerName);
//            buyer.setBuyerPw(buyerPw);
//            buyer.setBuyerEmail(buyerEmail);
            return user;
        }
    }

    @Data
    public static class LoginDTO{
        private String userName;
        private String userPw;
    }
}
