package com.snofty.mm.api.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.snofty.common.log.SnoftyLogger;
import com.snofty.mm.api.vo.Transaction;

@Path("/MM")
public class SnoftyMMService {
	
	private SnoftyLogger _logger=new SnoftyLogger(getClass());

	@POST
	@Path("/createTransaction")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTransaction(Transaction transaction){
		_logger.debug=true;
		_logger.debug(transaction);
		return Response.ok().build();
	}
}
