package com.example.SampleEcommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String greet()
	{
		return "WELCOME TO SAMPLE ECOMMERCE PROJECT";
	}
	@RequestMapping("/products")
	public List<Product>getproducts()
	{
		return service.getProducts();
	}
	@PutMapping("/products")
	public void updateproduct(@RequestBody Product prod)
	{
		service.updateProduct(prod);
	}
	@PostMapping("/products")
	public void addproduct(@RequestBody Product prod)
	{
		service.addProduct(prod);
	}
	@GetMapping("/products/{prodId}")
	public  Optional<Product> getById( @PathVariable int prodId) {
        
        return service.getById(prodId);
  }
	@DeleteMapping ("/products/{prodId}")
	public void deleteproduct(@PathVariable int prodId)
	{
		service.deleteProduct(prodId);
		
	}
}
