package com.elasticSearch.Elastic.Search.api;


import com.elasticSearch.Elastic.Search.entity.Product;
import com.elasticSearch.Elastic.Search.respository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @PostConstruct
    public void init(){
        Product product =new Product();
        product.setName("Sleepy Sensitive Islak Havlu 90'lı 12 Adet 1080 Yaprak");
        product.setCode("prd-code");
        product.setPrice(100.0);
        product.setDate(Calendar.getInstance().getTime());
        product.setId("K0001");
        productRepository.save(product);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable String search) {
        List<Product> products = productRepository.findByNameLikeOrCodeLike(search, search);
        return ResponseEntity.ok(products);
    }
}
