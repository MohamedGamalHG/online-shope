package com.onlineshop.product_service.repository;

import com.onlineshop.product_service.entity.mongo.MongoProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<MongoProduct,String> {
}
