package com.github.romankh3.tacocloud.repository.jpa;

import com.github.romankh3.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepositoryJpa extends CrudRepository<Taco, Long> {

}
