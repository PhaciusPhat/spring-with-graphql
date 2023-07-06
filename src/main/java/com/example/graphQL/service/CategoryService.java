package com.example.graphQL.service;

import com.example.graphQL.entity.Category;
import com.example.graphQL.entity.model.CategoryRequest;
import com.example.graphQL.repository.CategoryRepository;
import com.example.graphQL.utils.AppUtils;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    private Category getCategoryByName(String keyword){
        return categoryRepository.findByName(keyword).orElse(null);
    }

    @SneakyThrows
    public Category addCategory(CategoryRequest categoryRequest){
        if(getCategoryByName(categoryRequest.name()) == null){
            throw new Exception("This name already belongs to another category");
        }
        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setSlug(categoryRequest.slug());
        category.setIsDelete(AppUtils.DEFAULT_BOOLEAN_VALUE);
        category.setParentId(categoryRequest.parentId());
        return categoryRepository.save(category);
    }

    @SneakyThrows
    public Category editCategory(ObjectId id, CategoryRequest categoryRequest){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new Exception("Category not exist");
        }
        Category checkCategory = categoryRepository.findByName(categoryRequest.name()).orElse(null);
        if(checkCategory != null && !checkCategory.getId().equals(category.getId())){
            throw new Exception("This name is belongs to another category");
        }
        category.setName(categoryRequest.name());
        category.setSlug(categoryRequest.slug());
        category.setParentId(categoryRequest.parentId());
        return categoryRepository.save(category);
    }

    @SneakyThrows
    public void deleteCategory(ObjectId id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new Exception("Category not exist");
        }
        categoryRepository.deleteById(id);
    }

}
