package com.epam.jmstask.rest;

import com.epam.jmstask.jms.Producer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/book")
@Stateless
public class BookRestService {
	
	@Inject
	private Producer producer;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id") int id) {
		return new Book(id, "Dune", true);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setBook(Book book) throws URISyntaxException {
		System.out.println(book);
		producer.sendMessage(book);
		return Response.created(new URI("book/" + book.getId())).build();
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editBook(Book book) {
		System.out.println(book);
		return Response.ok().build();
	}
}