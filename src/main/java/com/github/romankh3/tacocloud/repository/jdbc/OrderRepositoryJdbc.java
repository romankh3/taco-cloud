package com.github.romankh3.tacocloud.repository.jdbc;

import com.github.romankh3.tacocloud.Order;

/**
 * Repository for {@link Order} object.
 */
public interface OrderRepositoryJdbc {

    Order save(Order order);
}
