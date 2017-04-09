package com.snofty.mm.util;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.snofty.mm.exception.MMDBException;

public final class MMDBConnector {

	private static final String DB_HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "test";

	private final MongoClient mongoClient;
	private final MongoDatabase database;

	private MMDBConnector() {
		MongoCredential credential = MongoCredential.createCredential("Snofty", DATABASE_NAME,
				"login@Snofty".toCharArray());
		mongoClient = new MongoClient(new ServerAddress(DB_HOSTNAME, PORT), Arrays.asList(credential));
		database = mongoClient.getDatabase(DATABASE_NAME);
	}

	private static class MMDBConnectionProvider {
		static MMDBConnector mMDBConnector = new MMDBConnector();
	}

	public static MMDBConnector getInstance() throws MMDBException {
		try {
			return MMDBConnector.MMDBConnectionProvider.mMDBConnector;
		} catch (Throwable th) {
			throw new MMDBException(th, "DB connection failed");
		}
	}

	public MongoDatabase getMongoDatabase() {
		return database;
	}

	public MongoCollection<Document> getCollection(String name) {
		return getMongoDatabase().getCollection(name);
	}

}
