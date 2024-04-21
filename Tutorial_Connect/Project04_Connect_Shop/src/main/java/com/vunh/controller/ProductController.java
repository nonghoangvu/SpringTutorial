package com.vunh.controller;

import com.vunh.entity.Image;
import com.vunh.entity.Product;
import com.vunh.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @GetMapping
    String index(Model model){
        model.addAttribute("products", this.productService.getAll());
        model.addAttribute("VIEW", "product/index.jsp");
        return "index";
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Integer id){
        this.productService.delete(id);
        return "redirect:/product";
    }
    @GetMapping("/add")
    String create(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("VIEW", "product/create.jsp");
        return "index";
    }

    @PostMapping("/add")
    String store(Model model, @Validated @ModelAttribute("product") Product product, BindingResult result, @RequestParam("photo")MultipartFile photo){
        Path path = Paths.get("uploads/");
        try{
            Image image = new Image();
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            image.setUrl(photo.getOriginalFilename());
            image.setCreateDate(new Date());
            product.setImage(image);
        }catch (Exception e){
            log.info(e.toString());
        }
        if (result.hasErrors()){
            model.addAttribute("product", product);
            model.addAttribute("VIEW", "product/create.jsp");
            return "index";
        }
        this.productService.store(product);
        return "redirect:/product";
    }

    @GetMapping("/update")
    String edit(Model model, @RequestParam("id") Integer id){
        model.addAttribute("product", this.productService.findById(id));
        model.addAttribute("VIEW", "product/edit.jsp");
        return "index";
    }

    @PostMapping("/update")
    String update(@ModelAttribute("product") Product product, Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("product", product);
            model.addAttribute("VIEW", "product/edit.jsp");
            return "index";
        }
        Product prd = this.productService.findById(product.getId());
        prd.setProductName(product.getProductName());
        prd.setPrice(product.getPrice());
        prd.setDescription(product.getDescription());
        this.productService.store(prd);
        return "redirect:/product";
    }
}
