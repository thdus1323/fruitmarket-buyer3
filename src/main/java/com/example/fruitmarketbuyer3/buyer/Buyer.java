package com.example.fruitmarketbuyer3.buyer;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Table(name = "buyer_tb")
@NoArgsConstructor // SELECT할 때 SPRING이 NEW 해줌 (DEFAULT 생성자)
@Entity
public class Buyer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer buyerId;

    @Column(unique = true, nullable = false, length = 20)
    private String buyerName;

    @Column(nullable = false)
    private String buyerPw;

    @Column(nullable = false)
    private String buyerEmail;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Buyer(Integer buyerId, String buyerName, String buyerPw, String buyerEmail, LocalDateTime createdAt) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerPw = buyerPw;
        this.buyerEmail = buyerEmail;
        this.createdAt = createdAt;
    }
}
