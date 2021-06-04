package br.com.blz.testjava.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String sku;
	
	private String name;
	
	private Inventory inventory;
	
	private boolean isMarketable;

}
/*
 "sku": 43264,
    "name": "L'Oréal Professionnel Expert Absolut Repair Cortex Lipidium - Máscara de Reconstrução 500g",
    "inventory": {
        "quantity": 15,
        "warehouses": [
            {
                "locality": "SP",
                "quantity": 12,
                "type": "ECOMMERCE"
            },
            {
                "locality": "MOEMA",
                "quantity": 3,
                "type": "PHYSICAL_STORE"
            }
        ]
    },
    "isMarketable": true
 */
