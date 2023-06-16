package com.crud.crud.repository;

import com.crud.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositroy extends JpaRepository<Product,Integer> {

    Product findByName(String name);
}
