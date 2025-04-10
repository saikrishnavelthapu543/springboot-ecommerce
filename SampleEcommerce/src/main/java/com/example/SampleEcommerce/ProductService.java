package com.example.SampleEcommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	  public List<Product> getProducts() {
	      return repo.findAll();
	    }
	
	  public void addProduct(Product prod) {
	        repo.save(prod);
	    }
	  

	    public Optional<Product> getById(int prodId) {
	        return repo.findById(prodId);
	    }
	    
	    public void deleteProduct(int prodId) {
	        if (repo.existsById(prodId)) {
	            repo.deleteById(prodId);
	        } else {
	            // Handle the case where the product doesn't exist, if needed.
	            throw new IllegalArgumentException("Product with ID " + prodId + " does not exist.");
	        }
	    }
	    public void updateProduct(Product prod) {
	        if (repo.existsById(prod.getId())) {
	            repo.save(prod);
	        } else {
	            // Handle the case where the product doesn't exist, if needed.
	            throw new IllegalArgumentException("Product with ID " + prod.getId() + " does not exist.");
	        }
	    }

	
}
