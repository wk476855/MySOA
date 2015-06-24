package com.demo.resource;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wk on 2015/6/23.
 */
@XmlRootElement
public class TimeTable {
	private String date;
	private String time;
	private String lan;
	private String theater;
	private String type;
	private double price;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
