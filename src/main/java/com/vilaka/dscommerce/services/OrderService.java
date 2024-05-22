package com.vilaka.dscommerce.services;

import com.vilaka.dscommerce.dto.OrderDTO;
import com.vilaka.dscommerce.entities.Order;
import com.vilaka.dscommerce.repositories.OrderRepository;
import com.vilaka.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

}
