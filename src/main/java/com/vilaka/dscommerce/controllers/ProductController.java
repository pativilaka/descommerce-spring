package com.vilaka.dscommerce.controllers;

import com.vilaka.dscommerce.dto.ProductDTO;
import com.vilaka.dscommerce.dto.ProductMinDTO;
import com.vilaka.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductMinDTO> findById(@PathVariable Long id){
        ProductMinDTO productMinDto = service.findById(id);
        return ResponseEntity.ok(productMinDto);
    }

//    @GetMapping
//    public List<ProductDTO> findAll(){
//        List<ProductDTO> listDTO = service.findAll();
//        return listDTO;
//    }

    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAllPage(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable){
        Page<ProductMinDTO> allPage = service.findAllPage(name, pageable);
        return ResponseEntity.ok(allPage);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
