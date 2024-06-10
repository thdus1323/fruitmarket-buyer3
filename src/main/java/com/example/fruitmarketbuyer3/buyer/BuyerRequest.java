package com.example.fruitmarketbuyer3.buyer;

import lombok.Data;

public class BuyerRequest {

    @Data
    public static class JoinDTO{
        private String buyerName;
        private String buyerPw;
        private String buyerEmail;

        public Buyer toEntity(){
            Buyer buyer = new Buyer();
            buyer.setBuyerName(buyerName);
            buyer.setBuyerPw(buyerPw);
            buyer.setBuyerEmail(buyerEmail);
            return buyer;
        }
    }

    @Data
    public static class LoginDTO{
        private String buyerName;
        private String buyerPw;
    }
}
