package com.snofty.common.log.service;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.snofty.mm.db.service.MMDBService;
import com.snofty.mm.exception.MMDBException;

public class SnoftyLoggerService {

	private static final String DEFAULT_LOG_FILE_PATH = "D:/Stuff/projects/logs/mm.log";
	private static final String TABLE = "logs";
	private MMDBService mmdbService;

	public SnoftyLoggerService() {
		try {
			mmdbService = new MMDBService();
		} catch (MMDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getLoggerFilePath() {
		String path = DEFAULT_LOG_FILE_PATH;
		if (mmdbService != null) {
			Document projection=new Document();
			projection.put("path", 1);
			try {
				MongoCursor<Document> data=mmdbService.getData(new Document(), TABLE,projection);
				if(data!=null){
					return data.next().getString("path");
				}
			} catch (MMDBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return path;
	}
}
