package br.com.blz.testjava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.blz.testjava.model.Inventory;
import br.com.blz.testjava.model.Product;
import br.com.blz.testjava.model.Warehouse;

public class ProductServiceTests {

	private ProductService productSersvice;

	@BeforeEach
	void initUseCase() {
		productSersvice = new ProductService();
	}

	public Product createProduct(String sku, String name, List<Warehouse> list) {
		Product product = new Product();
		product.setSku(sku);
		product.setName(name);

		Inventory inventory = new Inventory();
		inventory.setQuantity(0);

		inventory.setWarehouses(list);
		product.setInventory(inventory);

		return product;
	}

	public Warehouse createWarehouse(String locality, int quantity, String type) {
		Warehouse warehouse = new Warehouse();

		warehouse.setLocality(locality);
		warehouse.setQuantity(quantity);
		warehouse.setType(type);

		return warehouse;
	}

	@Test
	public void calQuantity_shouldToCalculateQuantity() throws Exception {
		List<Warehouse> listWarehouse = new ArrayList<Warehouse>();

		listWarehouse.add(createWarehouse("SP", 2, "E-COMERCE"));
		listWarehouse.add(createWarehouse("RJ", 6, "E-COMERCE"));

		Product product = createProduct("1234", "Product 1", listWarehouse);
		product = productSersvice.calcQuantity(product);

		assertEquals(8, product.getInventory().getQuantity());
		assertEquals(false, product.isMarketable());
	}
	
	@Test
	public void calQuantity_notShouldToCalculateQuantityWhenHaveNotInventory() throws Exception {
		Product product = createProduct("1234", "Product 1", null);
		product = productSersvice.calcQuantity(product);

		assertEquals(0, product.getInventory().getQuantity());
		assertEquals(false, product.isMarketable());
	}

	@Test
	public void marketable_shouldToVerifyIfMarketable() throws Exception {
		List<Warehouse> listWarehouse = new ArrayList<Warehouse>();

		listWarehouse.add(createWarehouse("SP", 2, "ECOMMERCE"));
		listWarehouse.add(createWarehouse("RJ", 6, "PHYSICAL_STORE"));

		Product product = createProduct("1234", "Product 1", listWarehouse); 
		product = productSersvice.calcQuantity(product);
		product = productSersvice.VerifyMarketable(product);

		assertEquals(8, product.getInventory().getQuantity());
		assertEquals(true, product.isMarketable());
	}
	
	@Test
	public void marketable_notShouldToVerifyMarketableWhenHaveNotQuantity() throws Exception {
		Product product = createProduct("1234", "Product 1", null);
		product = productSersvice.VerifyMarketable(product);

		assertEquals(0, product.getInventory().getQuantity());
		assertEquals(false, product.isMarketable());
	}

}
