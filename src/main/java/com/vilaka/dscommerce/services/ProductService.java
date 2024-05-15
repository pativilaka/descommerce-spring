package com.vilaka.dscommerce.services;

import com.vilaka.dscommerce.dto.ProductDTO;
import com.vilaka.dscommerce.entities.Product;
import com.vilaka.dscommerce.repositories.ProductRepository;
import com.vilaka.dscommerce.services.exceptions.DataBaseException;
import com.vilaka.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductDTO findById(Long id){

        Optional<Product> result = repository.findById(id);
        Product product = result.orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado!"));

        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

//    @Transactional
//    public List<ProductDTO> findAll(){
//        List<Product> products = repository.findAll();
//        List<ProductDTO> productsDto = products.stream().map(ProductDTO::new).toList();
//        return productsDto;
//    }

    @Transactional
    public Page<ProductDTO> findAllPage(Pageable pageable){
        Page<Product> products = repository.findAll(pageable);
        Page<ProductDTO> pagesDTOS = products.map(ProductDTO::new);
        return pagesDTOS;
    }


    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    //@Transactional(Transactional.TxType.SUPPORTS)
    //@Transactional(propagation = Propagation.SUPPORTS)
    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referêncial!");
        }

    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgURL());
    }

}
