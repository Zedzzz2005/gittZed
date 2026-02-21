package com.resto.orders;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "menu")
public class menu {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_menu;
	private String food_name;
	private int food_price;
	
	public Long getId_menu() {
		return id_menu;
	}
	public void setId_menu(Long id_menu) {
		this.id_menu = id_menu;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}
	
	

}
