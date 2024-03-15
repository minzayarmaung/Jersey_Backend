package com.mit.storesystem.Controller.InvoiceController;

import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mit.storesystem.Entity.InvoiceAndStockDataRequest;
import com.mit.storesystem.Service.InvoiceService.InvoiceAndStockService;
import com.sun.jersey.multipart.FormDataParam;

@Path("invoiceAndStockData")
public class InvoiceAndStockDataApi {
	
	// Saving InvoiceAndStockData
	
	
	// Updating InvoiceAndStockData
	@POST()
	@Path("/save")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveInvoiceAndStockData(
			@FormDataParam ("invoiceId") long invoiceId,
			@FormDataParam ("cashierName") String cashierName,
			@FormDataParam ("date") String date,
			@FormDataParam ("time") String time ,
			@FormDataParam("branch") String branch,
			@FormDataParam("center") String center,
			@FormDataParam("stockId") Long stockId,
			@FormDataParam("name") String name,
			@FormDataParam("price") Float price,
			@FormDataParam("quantity") int quantity,
			@FormDataParam("amount") Float amount,
			@FormDataParam("file") InputStream fileStream
			
	) throws SQLException{	
			
		try {
			InvoiceAndStockDataRequest request = new InvoiceAndStockDataRequest(
				    invoiceId, cashierName, date, time, branch, center, stockId , name, price, quantity, amount, fileStream, null);
				
			InvoiceAndStockService.createNewData(request);
			return Response.status(Response.Status.OK).entity("Data Saved Successfully !").build(); 
					
		} catch (Exception e) {
			e.printStackTrace();	
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to Save Data").build();
		}
		
	}

}
