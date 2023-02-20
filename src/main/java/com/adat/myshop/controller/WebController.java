package com.adat.myshop.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adat.myshop.domain.Product;
import com.adat.myshop.service.ProductService;

/**
 * Controlador para la web
 */
@Controller
public class WebController {
 
    @Autowired
    private ProductService productService;
 
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    //@RequestMapping(value="/catalog/{id}", method = RequestMethod.PUT)
    @PutMapping(value="/productoactualizado/{id}")
	public String modifyProduct(Model model, @PathVariable long id, @RequestBody Product product) {
    	
		product = productService.increasePrice(id, product.getPrice());
		return "productoactualizado";
	}
    
    @RequestMapping(value="/productoactualizado/{id}")
	public String modifyProduct(Model model, @PathVariable long id) {
    	
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "productoactualizado";
	}
	
    @RequestMapping(value = "/catalog")    
    public String catalog(Model model, @RequestParam(required = false) String category) {
    	Set<Product> products;
    	if(category!=null) {
    		products = productService.findAllProducts(category);
    	}else {
    		products = productService.findAllProducts();
    	}
        model.addAttribute("products", products);
        return "catalog";
    }
    

 
    
}
