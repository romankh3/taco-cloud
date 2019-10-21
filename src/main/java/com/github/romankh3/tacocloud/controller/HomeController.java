package com.github.romankh3.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home {@link Controller}
 */
@Controller
public class HomeController {

    public static final String REDIRECT_NAME = "redirect:";
    public static final String ROOT_NAME = "/";

    public static final String HOME_VIEW_NAME = "home";

    @GetMapping("/")
    public String home() {
        return HOME_VIEW_NAME;
    }

}
