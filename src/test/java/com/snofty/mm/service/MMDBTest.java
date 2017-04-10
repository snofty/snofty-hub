package com.snofty.mm.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bson.Document;

import com.snofty.mm.db.service.MMDBService;
import com.snofty.mm.exception.MMDBException;

public class MMDBTest {

	public static void main(String[] args) {
		/*MMDBService mmdbService=new MMDBService();
		Map<String, Object> data=new HashMap<>();
		data.put("Type", 4);
		data.put("Amount", 38415);
		mmdbService.insertData(data);*/
		
		try {
			new MMDBTest().displayData();
		} catch (MMDBException e) {
			System.err.println("DB connection failed");
		}

	}
	
	void displayData() throws MMDBException{
		MMDBService mmdbService=new MMDBService();
		Map<String, Object> data=new HashMap<>();
		data.put("Type", 4);
		System.out.println(mmdbService.getData(new Document(data), "test").next());
	}
	
	void insertData() throws MMDBException{
		MMDBService mmdbService=new MMDBService();
		Map<String, Object> data=new LinkedHashMap<>();
		data.put("path", "D:/Stuff/projects/logs/mm.log");
		mmdbService.insertData(data, "logs");
	}

}
