package com.example.Restaurant.Service;

import com.example.Restaurant.domain.Product;
import com.example.Restaurant.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends GenericService<Product, Integer> {
    Page<ProductDto> getByName(Pageable pageable, String name, String orderBy, String direction);
}