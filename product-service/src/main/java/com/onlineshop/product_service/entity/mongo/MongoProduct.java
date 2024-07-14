package com.onlineshop.product_service.entity.mongo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MongoProduct {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
