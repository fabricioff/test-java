package br.com.blz.testjava.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.blz.testjava.model.Product;
import br.com.blz.testjava.service.ProductService;

public class ProductRepository {
	
	private static final ProductService productService = new ProductService();
	
	static private Map<String, Product> mapProducts = new LinkedHashMap<String, Product>();
	
	static public String add(Product product) {
		StringBuilder status = new StringBuilder();
		
		if (!mapProducts.containsKey(product.getSku())) {
			mapProducts.put(product.getSku(), product);
			status.append("Produto adicionado com sucesso.");
		} else {
			status.append("Produto já existente.");
		}
		
		return status.toString();
	}
	
	static public Product findBySku(String sku) {
		Product product = mapProducts.get(sku);
		
		if (product != null) {
			product = productService.calcQuantity(product);		
			product = productService.VerifyMarketable(product);
		}
		
		return product;
	}
	
	static public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		for (Product product : mapProducts.values()) {
			product = productService.calcQuantity(product);			
			product = productService.VerifyMarketable(product);
			list.add(product);
		}		
		return list;
	}
	
	static public String removeProduct(String sku) {
		StringBuilder status = new StringBuilder();
		Product product = mapProducts.get(sku);
		
		if (product != null) {
			mapProducts.remove(sku);
			status.append("Produto remvido com sucesso.");
		} else {
			status.append("Produto não encontrado.");
		}
		
		return status.toString();
	}

}
