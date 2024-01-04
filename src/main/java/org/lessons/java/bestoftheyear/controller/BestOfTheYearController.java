package org.lessons.java.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("year",2023);
        model.addAttribute("name", "Vanny");
        return "home";
    }

}
