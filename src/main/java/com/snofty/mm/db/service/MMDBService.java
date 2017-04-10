package com.snofty.mm.db.service;

import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.snofty.mm.exception.MMDBException;
import com.snofty.mm.util.MMDBConnector;

public class MMDBService {
	MMDBConnector mMDBConnector;

	public MMDBService() throws MMDBException {
		try {
			mMDBConnector = MMDBConnector.getInstance();
		} catch (MMDBException de) {
			throw de;
		}
	}

	@Deprecated
	public boolean insertData(Map<String, Object> data) {
		boolean isSuccess = false;
		mMDBConnector.getCollection("test").insertOne(new Document(data));
		return isSuccess;
	}

	public boolean insertData(Map<String, Object> data, String table) throws MMDBException {
		boolean isSuccess = false;
		try {
			getCollection(table).insertOne(new Document(data));
			isSuccess = true;
		} catch (Exception e) {
			throw new MMDBException(e.getMessage());
		}
		return isSuccess;
	}

	public MongoCursor<Document> getData(Document query, String table) throws MMDBException {
		try {
			return getCollection(table).find(query).iterator();
		} catch (Exception e) {
			throw new MMDBException(e);
		}
	}

	private MongoCollection<Document> getCollection(String table) {
		return mMDBConnector.getCollection(table);
	}

	public MongoCursor<Document> getData(Bson bson, String table, Document projection) throws MMDBException {
		try {
			FindIterable<Document> query = getCollection(table).find(bson);
			if (projection != null) {
				return query.projection(projection).iterator();
			}
			return query.projection(projection).iterator();
		} catch (Exception e) {
			throw new MMDBException(e);
		}
	}
}
