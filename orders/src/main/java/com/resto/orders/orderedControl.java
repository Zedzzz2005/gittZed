package com.resto.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordered")
@CrossOrigin(origins = "*")
public class orderedControl {
	@Autowired
	private orderService orderService;

	public orderedControl(orderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public order createOrder(@RequestBody orderReq request) {
		return orderService.createOrder(request);
	}

	@GetMapping("/{id}")
	public order getOrder(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}

}
