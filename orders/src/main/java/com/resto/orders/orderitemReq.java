package com.resto.orders;

public class orderitemReq {
	private Long id_menu;
	private int quantity;
	
	public Long getId_menu() {
		return id_menu;
	}
	public void setId_menu(Long id_menu) {
		this.id_menu = id_menu;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
