package com.github.romankh3.tacocloud.repository;

import com.github.romankh3.tacocloud.Order;

/**
 * Repository for {@link Order} object.
 */
public interface OrderRepository {

    Order save(Order order);
}
