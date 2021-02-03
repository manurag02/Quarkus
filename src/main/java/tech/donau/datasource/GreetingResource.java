package tech.donau.datasource;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@Path("/hello")
public class GreetingResource {
	
	@Inject
	EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> hello() throws SQLException {
    	return Book.findAllBooks();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Book saveBook(Book book)
    {
//    	manager.persist(book);
    	book.persist();
    	return book;
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Book updateBook(@PathParam("id") Integer id,Book book)
    {
    	manager.merge(book);
    	return book;
    }
    
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Boolean deleteBook(@PathParam("id") long id)
    {
    	Book.delete("id",id);
    	return true;
    }
    
  
}