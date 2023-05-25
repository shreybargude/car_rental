package com.car.rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car")
public class Car {
	@Id
	private String _id;
	private String carCompany;
	private String carColor;
	private String carModel;
	private String carType;
	private String carImg;
	private String car360;
	private String carOwner;
	private String numPlate;
	private String regDate;
	private String insurance;
	private String insuranceValidity;
	private int passangerCapacity;
	private String fuelType;
	private String feature;
	private long totalRunning;
	private String _v;
	private float charge;

//	@ManyToOne
//	private User user;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String _id, String carCompany, String carColor, String carModel, String carType, String carImg,
			String car360, String carOwner, String numPlate, String regDate, String insurance,
			String insuranceValidity, int passangerCapacity, String fuelType, String feature, long totalRunning,
			String _v, float charge) {
		super();
		this._id = _id;
		this.carCompany = carCompany;
		this.carColor = carColor;
		this.carModel = carModel;
		this.carType = carType;
		this.carImg = carImg;
		this.car360 = car360;
		this.carOwner = carOwner;
		this.numPlate = numPlate;
		this.regDate = regDate;
		this.insurance = insurance;
		this.insuranceValidity = insuranceValidity;
		this.passangerCapacity = passangerCapacity;
		this.fuelType = fuelType;
		this.feature = feature;
		this.totalRunning = totalRunning;
		this._v = _v;
		this.charge = charge;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarImg() {
		return carImg;
	}
	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}
	public String getCar360() {
		return car360;
	}
	public void setCar360(String car360) {
		this.car360 = car360;
	}
	public String getCarOwner() {
		return carOwner;
	}
	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}
	public String getNumPlate() {
		return numPlate;
	}
	public void setNumPlate(String numPlate) {
		this.numPlate = numPlate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsuranceValidity() {
		return insuranceValidity;
	}
	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}
	public int getPassangerCapacity() {
		return passangerCapacity;
	}
	public void setPassangerCapacity(int passangerCapacity) {
		this.passangerCapacity = passangerCapacity;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public long getTotalRunning() {
		return totalRunning;
	}
	public void setTotalRunning(long totalRunning) {
		this.totalRunning = totalRunning;
	}
	public String get_v() {
		return _v;
	}
	public void set_v(String _v) {
		this._v = _v;
	}
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	@Override
	public String toString() {
		return "Car [_id=" + _id + ", carCompany=" + carCompany + ", carColor=" + carColor + ", carModel=" + carModel
				+ ", carType=" + carType + ", carImg=" + carImg + ", car360=" + car360 + ", carOwner=" + carOwner
				+ ", numPlate=" + numPlate + ", regDate=" + regDate + ", insurance=" + insurance
				+ ", insuranceValidity=" + insuranceValidity + ", passangerCapacity=" + passangerCapacity
				+ ", fuelType=" + fuelType + ", feature=" + feature + ", totalRunning=" + totalRunning + ", _v=" + _v
				+ ", charge=" + charge + "]";
	}
	
	
	
	
}
