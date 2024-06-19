package com.example.fruitmarketbuyer3.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //3. 상품목록
    public List<ProductResponse.ListDTO> getLists(){
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductResponse.ListDTO::new)
                .toList();
    }

    //상품상세보기
    public ProductResponse.DetailDTO getProductDetail(Integer productId){
        Product product = productRepository.findById(productId);
        return new ProductResponse.DetailDTO(product);
    }

}
