package com.example.graphQL.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Category")
public class Category {
    @Id
    @Field("_id")
    private ObjectId id;
    private String name;
    private String slug;
    private UUID parentId;
    private Boolean isDelete;
    private List<String> subCategory;
}
