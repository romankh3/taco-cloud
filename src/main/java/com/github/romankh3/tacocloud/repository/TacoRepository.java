package com.github.romankh3.tacocloud.repository;

import com.github.romankh3.tacocloud.Taco;

/**
 * Repository for {@link Taco} object.
 */
public interface TacoRepository {

    Taco save(Taco design);
}
