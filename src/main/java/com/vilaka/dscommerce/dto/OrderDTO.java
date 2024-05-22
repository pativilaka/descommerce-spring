package com.vilaka.dscommerce.dto;

import com.vilaka.dscommerce.entities.Order;
import com.vilaka.dscommerce.entities.OrderItem;
import com.vilaka.dscommerce.entities.OrderStatus;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private UserMinDTO client;
    private PaymentDTO payment;
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, UserMinDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new UserMinDTO(entity.getClient());
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        for (OrderItem item : entity.getItems()){
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            items.add(itemDTO);
        }
    }

    public Double getTotal(){
        double sum = 0;
        for (OrderItemDTO orderItemDTO : items){
            sum += orderItemDTO.getSubTotal();
        }
        return sum;
    }
}
