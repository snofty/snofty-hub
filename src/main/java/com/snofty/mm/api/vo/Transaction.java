package com.snofty.mm.api.vo;

import java.security.Timestamp;

import org.joda.money.Money;

public class Transaction {

	private String type;
	private Money amount;
	private String mode;
	private Timestamp timestamp;
	private String bank;
	private String category;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Transaction [type=" + type + ", amount=" + amount + ", mode=" + mode + ", timestamp=" + timestamp
				+ ", bank=" + bank + ", category=" + category + "]";
	}
}
