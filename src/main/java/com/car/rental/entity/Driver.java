package com.car.rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="driver")
public class Driver {
	@Id
    private String _id;
	private String driverImg;
	private String driverName;
	private String drivingExperiance;
	private String driverMobNo;
	private String availability;
	private String food;
	private String smoke;
	private String drink;
	private float charges;
	private float _v;
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String _id, String driverImg, String driverName, String drivingExperiance, String driverMobNo,
			String availability, String food, String smoke, String drink, float charges, float _v) {
		super();
		this._id = _id;
		this.driverImg = driverImg;
		this.driverName = driverName;
		this.drivingExperiance = drivingExperiance;
		this.driverMobNo = driverMobNo;
		this.availability = availability;
		this.food = food;
		this.smoke = smoke;
		this.drink = drink;
		this.charges = charges;
		this._v = _v;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDriverImg() {
		return driverImg;
	}

	public void setDriverImg(String driverImg) {
		this.driverImg = driverImg;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDrivingExperiance() {
		return drivingExperiance;
	}

	public void setDrivingExperiance(String drivingExperiance) {
		this.drivingExperiance = drivingExperiance;
	}

	public String getDriverMobNo() {
		return driverMobNo;
	}

	public void setDriverMobNo(String driverMobNo) {
		this.driverMobNo = driverMobNo;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public float getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}

	public float get_v() {
		return _v;
	}

	public void set_v(float _v) {
		this._v = _v;
	}

	@Override
	public String toString() {
		return "Driver [_id=" + _id + ", driverImg=" + driverImg + ", driverName=" + driverName + ", drivingexperiance="
				+ drivingExperiance + ", driverMobNo=" + driverMobNo + ", availability=" + availability + ", food=" + food
				+ ", smoke=" + smoke + ", drink=" + drink + ", charges=" + charges + ", _v=" + _v + "]";
	}
	
		
	
}
