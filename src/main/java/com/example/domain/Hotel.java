package com.example.domain;

public class Hotel {
	
	private Integer id;
	private String areaName;
	private String hotelName;
	private String Address;
	private String nearest_station;
	private Integer price;
	private String parking;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNearest_station() {
		return nearest_station;
	}
	public void setNearest_station(String nearest_station) {
		this.nearest_station = nearest_station;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", Address=" + Address
				+ ", nearest_station=" + nearest_station + ", price=" + price + ", parking=" + parking + "]";
	}
}
