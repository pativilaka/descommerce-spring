package com.vilaka.dscommerce.controllers;

import com.vilaka.dscommerce.dto.ProductDTO;
import com.vilaka.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

//    @GetMapping
//    public List<ProductDTO> findAll(){
//        List<ProductDTO> listDTO = service.findAll();
//        return listDTO;
//    }

    @GetMapping
    public Page<ProductDTO> findAllPage(Pageable pageable){
        Page<ProductDTO> allPage = service.findAllPage(pageable);
        return allPage;
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto){
        return service.insert(dto);
    }

}
