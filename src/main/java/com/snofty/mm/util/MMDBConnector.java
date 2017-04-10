package com.snofty.mm.util;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
	private static final int DEFAULT_DB_CACHE_COUNT = 5;
	private int connectionId;

	private final MongoClient mongoClient;
	private final MongoDatabase database;
	private static final Lock lock = new ReentrantLock();

	private MMDBConnector() throws MMDBException {
		try {
			MongoCredential credential = MongoCredential.createCredential("Snofty", DATABASE_NAME,
					"login@Snofty".toCharArray());
			mongoClient = new MongoClient(new ServerAddress(DB_HOSTNAME, PORT), Arrays.asList(credential));
			database = mongoClient.getDatabase(DATABASE_NAME);
			connectionId = ThreadLocalRandom.current().nextInt(5);
		} catch (Exception e) {
			throw new MMDBException(e, "DB connection failed");
		}
	}

	public int getConnectionId() {
		return connectionId;
	}

	public static MMDBConnector getInstance() throws MMDBException {
		Set<MMDBConnector> connectorCache = MMDBCacheProvider.getConnectorCache();
		MMDBConnector mmDBConnector = null;
		try {
			lock.lock();
			if (connectorCache.isEmpty()) {
				int count = DEFAULT_DB_CACHE_COUNT;
				while (count-- != 0) {
					mmDBConnector = createConnection();
					connectorCache.add(mmDBConnector);
				}
			} else {
				mmDBConnector = connectorCache.iterator().next();
			}
		} finally {
			lock.unlock();
		}
		return mmDBConnector;
	}

	private static MMDBConnector createConnection() throws MMDBException {
		try {
			return new MMDBConnector();
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
