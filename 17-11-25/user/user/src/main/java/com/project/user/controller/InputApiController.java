package com.project.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InputApiController {

    @GetMapping("/add")
    public int addNumbers(@RequestParam int x, @RequestParam int y) {
        return x+y;
    }

    @GetMapping("/search")
    public String search(@RequestParam String query) {
        return "You searched for: " + query;
    }
}
