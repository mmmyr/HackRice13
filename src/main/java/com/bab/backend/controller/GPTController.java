package com.bab.backend.controller;

import com.bab.backend.service.GPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/chat")
public class GPTController {

    @Autowired
    private GPTService gptService;

    @GetMapping
    public String chatInterface() {
        return "chat";
    }

    @PostMapping("/ask")
    public String askGPT(@RequestParam String userMessage, Model model) {
        String gptResponse = gptService.getGPTResponse(userMessage);
        model.addAttribute("userMessage", userMessage);
        model.addAttribute("gptResponse", gptResponse);
        return "chat";
    }
}
