package br.com.blz.testjava.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer quantity;
	
	private List<Warehouse> warehouses;
}
