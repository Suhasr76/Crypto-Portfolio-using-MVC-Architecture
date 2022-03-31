package com.example.mvccryptotracker;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("crypto")
public class Crypto {
	private String name;
	// private String description;
	private String shortForm;
	private int price;
	private int funds;
	private int value;

	// Getter Functions
	public String getName() {
		return name;
	}

	public String getShortForm() {
		return shortForm;
	}

	public int getPrice() {
		return price;
	}

	public int getFunds() {
		return funds;
	}

	public int getValue() {
		return funds * price;
	}

	// Setter Functions
	public void setName(String name) {
		this.name = name;
	}

	public void setShortForm(String shortForm) {
		this.shortForm = shortForm;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public void setValue(int funds, int price) {
		this.value = this.funds * this.price;
	}

}
