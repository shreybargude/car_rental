package com.car.rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atm {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String _id;
	private String cardNo;

	//	private Driver driver;
	
	public Atm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Atm(String _id, String cardNo) {
		super();
		this._id = _id;
		this.cardNo = cardNo;
	}
	public String getId() {
		return _id;
	}
	public void setId(String _id) {
		this._id = _id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public String toString() {
		return "Payment [_id=" + _id + ", cardNo=" + cardNo + "]";
	}
	
	
}
