package com.adat.myshop.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adat.myshop.domain.Product;
import com.adat.myshop.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
 
    @Autowired
    private ProductRepository productRepository;
 
    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }
 
    @Override
    public Set<Product> findAllProducts(String category) {
        return productRepository.findByCategory(category);
    }
    
    @Override
    public Product increasePrice(Product product, float extraPrice) {
    	product.setPrice(product.getPrice()+extraPrice);
    	productRepository.save(product);
    	return product;
    }  

	@Override
	public Set<Product> findAllById(long id) {
		return productRepository.findAllById(id);
	}

	@Override
	public Product findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product increasePrice(long idProduct, float extraPrice) {
		Product p= productRepository.findById(idProduct);
		p.setPrice(p.getPrice()+extraPrice);
		productRepository.save(p);
		return p;
	}

}
