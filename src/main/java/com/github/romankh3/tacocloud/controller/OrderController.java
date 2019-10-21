package com.github.romankh3.tacocloud.controller;

import static com.github.romankh3.tacocloud.controller.HomeController.REDIRECT_NAME;
import static com.github.romankh3.tacocloud.controller.HomeController.ROOT_NAME;

import com.github.romankh3.tacocloud.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    public static final String ORDER_FORM_VIEW_NAME = "orderForm";

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return ORDER_FORM_VIEW_NAME;
    }

    @PostMapping
    public String processOrder(Order order) {
        log.info("Order submitted: " + order);
        return REDIRECT_NAME + ROOT_NAME;
    }
}
