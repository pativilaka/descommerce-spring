package com.vilaka.dscommerce.services;

import com.vilaka.dscommerce.dto.ProductDTO;
import com.vilaka.dscommerce.entities.Product;
import com.vilaka.dscommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductDTO findById(Long id){

        Optional<Product> result = repository.findById(id);
        Product product = result.get();

        ProductDTO dto = new ProductDTO(product);
        return dto;
    }
}
