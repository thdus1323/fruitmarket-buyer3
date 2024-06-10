package com.example.fruitmarketbuyer3.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    //3,상품목록구현
    public List<Product> findAll(){
        Query query = em.createQuery("select p from Product p order by p.productId desc", Product.class);
        return query.getResultList();
    }
}
