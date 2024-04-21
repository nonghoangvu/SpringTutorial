package com.vunh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Product {
    private String productName;
    private List<String> url = new ArrayList<>();
}
