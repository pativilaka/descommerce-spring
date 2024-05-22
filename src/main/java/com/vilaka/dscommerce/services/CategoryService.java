package com.vilaka.dscommerce.services;

import com.vilaka.dscommerce.dto.CategoryDTO;
import com.vilaka.dscommerce.entities.Category;
import com.vilaka.dscommerce.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<CategoryDTO> findAll(){
        List<Category> categories = repository.findAll();
        List<CategoryDTO> categoriesDto = categories.stream().map(CategoryDTO::new).toList();
        return categoriesDto;
    }

}
