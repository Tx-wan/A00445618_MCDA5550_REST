package com.twan.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hotel_tbl")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "hotelName", nullable = false)
	private String hotelName;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@Column(name = "available", nullable = false)
	private boolean availability;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean getAvailability() {
		return availability;
	}
	
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	@Override
    public String toString() {
        return "Hotel [id=" + id + ", hotelName=" + hotelName + ", price=" + price + ", availability=" + availability 
       + "]";
    }
	
}
