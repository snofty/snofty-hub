package com.snofty.mm.util;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

public class ConversionUtil {

	public static BasicDBObject convertJavaToDocument(Object object) {
		Gson gson = new Gson();
		BasicDBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(object));
		return dbObject;
	}

	public static Object convertDocumentToJava(String json, Class glass){
		Gson gson = new Gson();
		return gson.fromJson(json, glass);
	}
}
