package com.example.graphQL.repository;

import com.example.graphQL.entity.Category;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
    Optional<Category> findByName(String keyword);
}
