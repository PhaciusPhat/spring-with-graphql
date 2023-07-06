package com.example.graphQL.entity.model;

import com.example.graphQL.entity.Category;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.UUID;



@Builder
public record CategoryRequest (ObjectId id, String name, String slug, UUID parentId){
    public CategoryRequest fromCategory(Category category){
        return builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .parentId(category.getParentId())
                .build();
    }
}
