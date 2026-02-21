package com.resto.orders;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class orderService {
	private orderRep orderRep;
	private menuRep menuRep;

	public orderService(orderRep orderRep, menuRep menuRep) {
		this.orderRep = orderRep;
		this.menuRep = menuRep;
	}

	public order createOrder(orderReq request) {

	    order order = new order();
	    //sets the date of creation
	    order.setOrderAt(LocalDateTime.now());
	    
	    //checks if items list is empty
	    if(request.getItems() == null || request.getItems().isEmpty()) {
	        throw new IllegalArgumentException("Order must have at least one item");
	    }

	    for (orderitemReq req : request.getItems()) {

	        if(req.getId_menu() == null) {
	            throw new IllegalArgumentException("Menu ID must not be null");
	        }

	        menu menu = menuRep.findById(req.getId_menu())
	            .orElseThrow(() -> new RuntimeException("Menu not found"));

	        ordered item = new ordered();
	        item.setOrder(order);
	        item.setMenu(menu);
	        item.setQuantity(req.getQuantity());
	        item.setPrice_at_time(menu.getFood_price());

	        order.getItems().add(item);
	    }
	    return orderRep.save(order);
	}

	public order getOrderById(Long id) {
		return orderRep.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}
	
	//To get items by day, week, or month of its creation
	
	public List<order> getOrdersToday(){
		LocalDate today = LocalDate.now();
		
		LocalDateTime start = today.atStartOfDay();
		LocalDateTime end = today.atTime(LocalTime.MAX);
		
		return orderRep.findByOrderAtBetween(start, end);
	}
	
	public List<order> getOrdersThisWeek(){
		LocalDate now = LocalDate.now();
		
		LocalDate startOfWeek = now.with(DayOfWeek.MONDAY);
		LocalDateTime start = startOfWeek.atStartOfDay();
		LocalDateTime end = LocalDateTime.now();
		
		return orderRep.findByOrderAtBetween(start, end);
	}
	
	public List<order> getOrdersThisMonth(){
		LocalDate now = LocalDate.now();
		
		LocalDate startOfMonth = now.withMonth(1);
		LocalDateTime start = startOfMonth.atStartOfDay();
		LocalDateTime end = LocalDateTime.now();
		
		return orderRep.findByOrderAtBetween(start, end);
	}
}
