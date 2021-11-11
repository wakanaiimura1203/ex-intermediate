package com.example.form;

public class HotelSearchForm {
	
	private String price;
	
	public Integer getIntPrice() {
		return Integer.parseInt(this.price);
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
