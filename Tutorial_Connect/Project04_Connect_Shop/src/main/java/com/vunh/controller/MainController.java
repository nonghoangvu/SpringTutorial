package com.vunh.controller;

import com.vunh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("products", this.productService.getAll());
        model.addAttribute("VIEW", "home.jsp");
        return "index";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                System.out.println("Uploaded file: " + file.getOriginalFilename());
            }
        }
        return "Test";
    }
}
