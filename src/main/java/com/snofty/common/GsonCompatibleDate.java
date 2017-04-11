package com.snofty.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class GsonCompatibleDate {
	@SerializedName("$date")
	public Long date;

	public GsonCompatibleDate(Long date) {
		this.date = date;
	}

	public String getDate() {
		return new SimpleDateFormat("dd,MMM yyyy HH:mm:ss.SSS").format(new Date(date));
	}

	public void setDate(Date date) {
		this.date = date.getTime();
	}
}
