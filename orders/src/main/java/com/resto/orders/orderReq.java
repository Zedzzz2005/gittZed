package com.resto.orders;

import java.util.List;

public class orderReq {
	private List<orderitemReq> items;
	
	public List<orderitemReq> getItems(){
		return items;
	}
	
	public void setItems(List<orderitemReq> items) {
		this.items = items;
	}
}
