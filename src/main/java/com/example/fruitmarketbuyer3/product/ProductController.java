package com.example.fruitmarketbuyer3.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String list(HttpServletRequest request){
        List<ProductResponse.ListDTO> productList = productService.getLists();
        request.setAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/product/{productId}/detail")
    public String detail(@PathVariable Integer productId, HttpServletRequest request){
        ProductResponse.DetailDTO product = productService.getProductDetail(productId);
        request.setAttribute("model", product);
        return "product/detail";
    }
}
