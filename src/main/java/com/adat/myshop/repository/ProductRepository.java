package com.adat.myshop.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adat.myshop.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
 
    Set<Product> findAll();
    Set<Product> findAllById(long id);
    Product findByName(String name);
    Product findById(long id);
    Set<Product> findByCategory(String category);
    Set<Product> findByNameAndPrice(String name, float price);

}

