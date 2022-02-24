package com.web.service.model.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERD(4),
	CANCELED(5);
	
	// codigo para o tipo enum
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//acessar o code
	public int getCode() {
		return code;
	}
	
	// Método estático porque vai funcionar sem precisar instanciar
	// percorre os valores do OrderStatus e  compara se o 'code' passado no argumento é igual ao value.getcode()
	// caso seja igual é retornado, caso não é lançado uma excessão
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido");
	}
}
