package com.snofty.mm.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.snofty.common.GsonCompatibleDate;

public class Transaction implements Serializable {

	private static final long serialVersionUID = -7526897394852731429L;
	public static final String TABLE_NAME = "Transaction";
	//private long _id;
	private String type;
	private BigDecimal amount;
	private String mode;
	private long timestamp;
	private String bank;
	private String category;
	private GsonCompatibleDate insertedAt;
	
	public GsonCompatibleDate getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(GsonCompatibleDate insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
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
