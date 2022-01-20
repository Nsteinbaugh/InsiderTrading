package com.insidertrading.stockscreener.controller;

import org.springframework.ui.Model;

public class HomeController {
    public String index(Model model) {
        return "index";
    }
}
