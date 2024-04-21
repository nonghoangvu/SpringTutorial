package com.vunh.controller;

import com.vunh.Product;
import com.vunh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ImageService service;

    @GetMapping
    String index() {
        return "index";
    }

    @GetMapping("/show")
    String show(Model model) {
        model.addAttribute("product", this.service.getProduct());
        return "show";
    }

    @PostMapping("/add")
    String store(@RequestParam("name") String name, @RequestParam("files") MultipartFile[] files) {
        Path path = Paths.get("uploads/");
        Product product = new Product();
        product.setProductName(name);
        List<String> strings = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    InputStream inputStream = file.getInputStream();
                    Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    strings.add(file.getOriginalFilename());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        product.setUrl(strings);
        this.service.setProduct(product);
        return "redirect:/show";
    }

    @RequestMapping("/img/{photo}")
    ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        if (photo != null && !photo.isEmpty()) {
            try {
                Path fileName = Paths.get("uploads", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                MediaType mediaType;
                if (photo.toLowerCase().endsWith(".jpg") || photo.toLowerCase().endsWith(".jpeg")) {
                    mediaType = MediaType.IMAGE_JPEG;
                } else if (photo.toLowerCase().endsWith(".png")) {
                    mediaType = MediaType.IMAGE_PNG;
                } else {
                    return ResponseEntity.badRequest().build();
                }
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(mediaType)
                        .body(byteArrayResource);
            } catch (Exception e) {
                throw new RuntimeException("Not found!");
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
