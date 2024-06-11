package com.example.fruitmarketbuyer3.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Table(name = "user_tb")
@NoArgsConstructor // SELECT할 때 SPRING이 NEW 해줌 (DEFAULT 생성자)
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;

    @Column(unique = true, nullable = false, length = 20)
    private String userName;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userEmail;

    // String role; // buyer, seller

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public User(Integer userId, String userName, String userPw, String userEmail, LocalDateTime createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.createdAt = createdAt;
    }
}
