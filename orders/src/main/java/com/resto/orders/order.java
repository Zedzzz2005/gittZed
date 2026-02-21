package com.resto.orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_order;
	@CreationTimestamp
	@Column(name = "order_at")
	private LocalDateTime orderAt;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<ordered> items = new ArrayList<>();

	public LocalDateTime getOrderAt() {
		return orderAt;
	}

	public void setOrderAt(LocalDateTime orderAt) {
		this.orderAt = orderAt;
	}

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}

	public List<ordered> getItems() {
		return items;
	}

	public void setItems(List<ordered> items) {
		this.items = items;
	}

}
