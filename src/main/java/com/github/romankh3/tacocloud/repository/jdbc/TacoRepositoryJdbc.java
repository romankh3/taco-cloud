package com.github.romankh3.tacocloud.repository.jdbc;

import com.github.romankh3.tacocloud.Taco;

/**
 * Repository for {@link Taco} object.
 */
public interface TacoRepositoryJdbc {

    Taco save(Taco design);
}
