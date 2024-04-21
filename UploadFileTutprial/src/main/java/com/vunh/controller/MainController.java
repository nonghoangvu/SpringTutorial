package com.vunh.controller;

import com.vunh.entity.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping
    String index(){
        return "index";
    }

    @PostMapping("/store")
    String store(@RequestParam("name") String name, @RequestParam("photo")MultipartFile photo, Model model){
        Info info = new Info();
        info.setName(name);
        if(photo.isEmpty()){
            return "index";
        }
        Path path = Paths.get("uploads/");
        try{
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            info.setPhoto(photo.getOriginalFilename());
            model.addAttribute("INFO", info);
        }catch (Exception e){
            log.info(e.toString());
        }
        return "view-info";
    }
}
