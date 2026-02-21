package com.resto.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordered")
public class ordered {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_menu")
	private menu menu;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_order")
	private order order;

	private int quantity;
	private int price_at_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice_at_time() {
		return price_at_time;
	}

	public void setPrice_at_time(int price_at_time) {
		this.price_at_time = price_at_time;
	}

	public menu getMenu() {
		return menu;
	}

	public void setMenu(menu menu) {
		this.menu = menu;
	}

	public order getOrder() {
		return order;
	}

	public void setOrder(order order) {
		this.order = order;
	}

}
