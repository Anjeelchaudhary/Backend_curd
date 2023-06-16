package com.crud.crud.service;

import com.crud.crud.entity.Product;
import com.crud.crud.repository.ProductRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //ekarMatlap ki productRepository he yaha inject karnu ie link karal has howai
    @Autowired
    private ProductRepositroy repositroy;

    public Product saveProduct(Product product) {
        return repositroy.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repositroy.saveAll(products);
    }

    public List<Product> getProducts() {
        return repositroy.findAll();
    }

    public Product getProductById(int id) {
        return repositroy.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repositroy.findByName(name);
    }
    public String deleteProduct(int id) {
         repositroy.deleteById(id);
        return "removed product who's id is = "+id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repositroy.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repositroy.save(existingProduct);
    }
}
