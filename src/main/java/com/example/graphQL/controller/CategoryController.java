package com.example.graphQL.controller;

import com.example.graphQL.entity.Category;
import com.example.graphQL.entity.model.CategoryRequest;
import com.example.graphQL.service.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @QueryMapping
    public List<Category> GetCategories(){
        return categoryService.getCategories();
    }

    @SchemaMapping(typeName = "Mutation", field = "AddCategory")
    public Category AddCategory(@Argument CategoryRequest categoryRequest){
        return categoryService.addCategory(categoryRequest);
    }

    @SchemaMapping(typeName = "Mutation", field = "EditCategory")
    public Category EditCategory(@Argument ObjectId id, @Argument CategoryRequest categoryRequest){
        return categoryService.editCategory(id, categoryRequest);
    }

    @SchemaMapping(typeName = "Mutation", field = "DeleteCategory")
    public Boolean DeleteCategory(@Argument ObjectId id){
        categoryService.deleteCategory(id);
        return true;
    }
}
