package com.snofty.mm.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import com.snofty.common.log.SnoftyLogger;
import com.snofty.mm.api.vo.Transaction;
import com.snofty.mm.db.service.MMDBService;
import com.snofty.mm.exception.MMDBException;
import com.snofty.mm.util.ConversionUtil;

@Path("/MM")
public class SnoftyMMService {

	private SnoftyLogger _logger = new SnoftyLogger(getClass());
	private MMDBService service;

	@POST
	@Path("/createTransaction")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTransaction(Transaction transaction) {
		_logger.debug = true;
		_logger.debug(transaction);
		if (transaction != null) {
//			transaction.setTimestamp(System.currentTimeMillis());
			Gson gson = new Gson();
			BasicDBObject transactionDB = (BasicDBObject) JSON.parse(gson.toJson(transaction));
			try {
				service = new MMDBService();
				transactionDB.put("insertedAt", new Date());
				service.insertData(transactionDB, Transaction.TABLE_NAME);
				return Response.ok(transaction).build();
			} catch (MMDBException e) {
				_logger.warn("inserting of transaction failed " + transaction + e.getMessage());
			}
		}
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTransactions")
	public Response getTransactions() {
		List<Transaction> transactions = new ArrayList<>();
		try {
			service = new MMDBService();
			MongoCursor<Document> cursor = service.getData(new Document(), Transaction.TABLE_NAME);
			_logger.debug = true;
			_logger.debug(cursor);
			while (cursor.hasNext()) {
				String json = cursor.next().toJson();
				_logger.debug(json);
				transactions.add(
						(Transaction) ConversionUtil.convertDocumentToJava(json, Transaction.class));
			}
		} catch (MMDBException e) {
			_logger.warn("getTransactions failed " + e.getMessage());
		}
		return Response.ok(transactions).build();
	}
}
