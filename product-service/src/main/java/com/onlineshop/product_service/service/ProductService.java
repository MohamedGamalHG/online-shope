package com.onlineshop.product_service.service;

import com.onlineshop.product_service.entity.dto.ProductRequest;
import com.onlineshop.product_service.entity.dto.ProductResponse;
import com.onlineshop.product_service.entity.mongo.MongoProduct;
import com.onlineshop.product_service.mapping.ProductRequestMap;
import com.onlineshop.product_service.mapping.ProductResponseMap;
import com.onlineshop.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMap productRequestMap;
    private final ProductResponseMap productResponseMap;

    public void createProduct(ProductRequest productRequest)
    {
        MongoProduct product = productRequestMap.convertTo(productRequest);
        productRepository.save(product);
        log.info("Product {} Is Saved", product.getId());
    }

    public List<ProductResponse> getAllProducts()
    {
        List<MongoProduct> mongoProducts = productRepository.findAll();
        return   mongoProducts.stream().map(product -> productResponseMap.convertTo(product)).toList();
    }
}
