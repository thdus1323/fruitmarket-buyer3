package com.example.fruitmarketbuyer3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO{
        private String userName;
        private String userPw;
        private String userEmail;
        private String role;


        public User toEntity(){
            User user = User.builder()
                    .userName(userName)
                    .userPw(userPw)
                    .userEmail(userEmail)
                    .role(role)
                    .build();
            return user;
        }
    }

    @Data
    public static class LoginDTO{
        private String userName;
        private String userPw;
        private String role;
    }
}
