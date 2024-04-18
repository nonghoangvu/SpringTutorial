package com.vunh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceCRUD<T>{
    public List<T> getAll();
    public Page<T> getAll(Pageable pageable);
}
