package com.onlineshop.product_service.mapping;

import com.onlineshop.product_service.entity.dto.ProductRequest;
import com.onlineshop.product_service.entity.mongo.MongoProduct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductRequestMap {
    private ModelMapper modelMapper;

    public ProductRequest convertTo(MongoProduct product)
    {
        return modelMapper.map(product,ProductRequest.class);
    }
    public MongoProduct convertTo(ProductRequest productRequest)
    {
        return modelMapper.map(productRequest,MongoProduct.class);
    }

}
