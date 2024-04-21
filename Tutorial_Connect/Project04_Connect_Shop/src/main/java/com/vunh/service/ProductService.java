package com.vunh.service;

import com.vunh.entity.Image;
import com.vunh.entity.Product;
import com.vunh.repository.ImageRepository;
import com.vunh.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Integer id){
        return this.productRepository.findById(id).orElse(new Product());
    }

    @Transactional
    public void store(Product product){
        this.productRepository.save(product);
        Image image = product.getImage();
        if (image != null) {
            this.imageRepository.save(image);
        }
    }

    @Transactional
    public void delete(Integer id){
        Optional<Product> object = this.productRepository.findById(id);
        if(object.isPresent()){
            try {
                Path imagePath = Paths.get("uploads", object.get().getImage().getUrl());
                Files.deleteIfExists(imagePath);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
            this.imageRepository.deleteById(object.get().getImage().getId());
            this.productRepository.deleteById(object.get().getId());
        }
    }
}
