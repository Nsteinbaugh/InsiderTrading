package com.insidertrading.stockscreener.controller;

import com.insidertrading.sec.api.SECApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) throws URISyntaxException, IOException, InterruptedException {
        SECApi secApi = new SECApi();
        model.addAttribute("latest10Q", secApi.getLatest10Q());
        return "index";
    }
}
