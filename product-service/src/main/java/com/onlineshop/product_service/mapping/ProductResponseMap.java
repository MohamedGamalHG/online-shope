package com.onlineshop.product_service.mapping;

import com.onlineshop.product_service.entity.dto.ProductRequest;
import com.onlineshop.product_service.entity.dto.ProductResponse;
import com.onlineshop.product_service.entity.mongo.MongoProduct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductResponseMap {
    private ModelMapper modelMapper;

    public ProductResponse convertTo(MongoProduct product)
    {
        return modelMapper.map(product,ProductResponse.class);
    }
    public MongoProduct convertTo(ProductResponse productResponse)
    {
        return modelMapper.map(productResponse,MongoProduct.class);
    }

}
