package com.example.graphQL.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String slug;
    private Long price;
    private Long amount;
    private String urlImage;
}
