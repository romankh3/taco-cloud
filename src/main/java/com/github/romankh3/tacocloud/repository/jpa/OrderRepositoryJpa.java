package com.github.romankh3.tacocloud.repository.jpa;

import com.github.romankh3.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositoryJpa extends CrudRepository<Order, Long> {

}
