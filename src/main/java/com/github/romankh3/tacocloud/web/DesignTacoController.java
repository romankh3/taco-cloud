package com.github.romankh3.tacocloud.web;

import com.github.romankh3.tacocloud.Ingredient;
import com.github.romankh3.tacocloud.Ingredient.Type;
import com.github.romankh3.tacocloud.Order;
import com.github.romankh3.tacocloud.Taco;
import com.github.romankh3.tacocloud.repository.jpa.IngredientRepositoryJpa;
import com.github.romankh3.tacocloud.repository.jpa.TacoRepositoryJpa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * todo add javadoc
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    public static final String DESIGN_VIEW_NAME = "design";

    private final IngredientRepositoryJpa ingredientRepository;
    private final TacoRepositoryJpa tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepositoryJpa ingredientRepository, TacoRepositoryJpa tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), ingredients.stream()
                    .filter(it -> it.getType().name().equals(type.name()))
                    .collect(Collectors.toList()));
        }

        model.addAttribute("design", new Taco());

        return DESIGN_VIEW_NAME;
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return DESIGN_VIEW_NAME;
        }

        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);

        log.info("Processing design: " + design);
        //go to http get request to this path.
        return "redirect:/orders/current";
    }
}
