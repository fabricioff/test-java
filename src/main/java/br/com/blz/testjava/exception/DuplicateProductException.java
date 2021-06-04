package br.com.blz.testjava.exception;

public class DuplicateProductException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DuplicateProductException(String skuProduct) {
		super(String.format(
				  "Dois produtos são considerados iguais se os seus skus forem iguais.\n"
				+ "SKU '%s' já existente.", skuProduct));
	}

}
