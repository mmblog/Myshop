package com.adat.myshop.service;

import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.adat.myshop.domain.Product;

public interface ProductService {
	Set<Product> findAllProducts();
    Set<Product> findAllProducts(String category);
    Set<Product> findAllById(long id);
    Product increasePrice(Product product, float extraPrice);
    Product increasePrice(long idProduct, float extraPrice);
    Product findById(long id);


}
