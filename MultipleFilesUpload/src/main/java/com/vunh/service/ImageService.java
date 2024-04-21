package com.vunh.service;

import com.vunh.Product;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ImageService {
    private Product product;
}
