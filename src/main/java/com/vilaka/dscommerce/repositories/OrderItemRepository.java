package com.vilaka.dscommerce.repositories;

import com.vilaka.dscommerce.entities.OrderItem;
import com.vilaka.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
