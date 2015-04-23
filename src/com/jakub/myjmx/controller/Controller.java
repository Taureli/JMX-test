package com.jakub.myjmx.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jakub.myjmx.mbean.UpdateList;

@Path("/")
public class Controller {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String main() {
		//whenever page is refreshed/entered a new element will be added
		UpdateList.getInstance().addElement();
		return "List updated";
	}
	
}
