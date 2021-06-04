package br.com.blz.testjava.model;


import java.io.Serializable;

import lombok.Data;

@Data
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String locality;
	
    private Integer quantity;
    
    private String type;
}
