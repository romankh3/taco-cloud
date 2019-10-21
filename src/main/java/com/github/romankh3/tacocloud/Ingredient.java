package com.github.romankh3.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * todo add Javadoc
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    /**
     * todo add javadoc
     */
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
