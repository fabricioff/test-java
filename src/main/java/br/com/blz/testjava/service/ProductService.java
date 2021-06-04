package br.com.blz.testjava.service;

import org.springframework.stereotype.Service;

import br.com.blz.testjava.model.Product;
import br.com.blz.testjava.model.Warehouse;

@Service
public class ProductService {

	public Product calcQuantity(Product product) {
		product.getInventory().setQuantity(0);
		if (product.getInventory() != null && product.getInventory().getWarehouses() != null) {
			for (Warehouse warehouse : product.getInventory().getWarehouses()) {
				Integer qtdeTotal = product.getInventory().getQuantity();

				product.getInventory().setQuantity(qtdeTotal + warehouse.getQuantity());
			}
		}

		return product;
	}

	public Product VerifyMarketable(Product product) {		
		if (product.getInventory() != null && product.getInventory().getQuantity() > 0) {
			product.setMarketable(true);
		} else {
			product.setMarketable(false);
		}

		return product;
	}

}
