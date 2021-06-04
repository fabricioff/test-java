package br.com.blz.testjava.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.blz.testjava.model.Product;
import br.com.blz.testjava.repository.ProductRepository;

@RestController
public class ProductController {
		
	@GetMapping("/listProduct")
	private List<Product> getAll() {
		return ProductRepository.getAll();
	}
	
	@GetMapping("/findProduct")
	private Product getProductBySku(@RequestParam String sku) {
		return ProductRepository.findBySku(sku);
	}
	
	@PostMapping("/createProduct")
	private String addProduct(@RequestBody Product product) {
		return String.format("%s\nSKU(%s)", ProductRepository.add(product), product.getSku());
	}
	
	@DeleteMapping("/deleteProduct")
	private String removeProduct(@RequestParam String sku) {
		return ProductRepository.removeProduct(sku);
	}

}
