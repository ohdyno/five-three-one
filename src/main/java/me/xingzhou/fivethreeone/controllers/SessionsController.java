package me.xingzhou.fivethreeone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionsController {
    @GetMapping("/users/{userId}/sessions")
    public void getHistory(@PathVariable String userId) {

    }
}
