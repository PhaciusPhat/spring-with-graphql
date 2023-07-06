package com.example.graphQL.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Product")
public class Product {
    @Id
    private UUID id;
    private String name;
    private String slug;
    private Long price;
    private Long amount;
    private String urlImage;
}
