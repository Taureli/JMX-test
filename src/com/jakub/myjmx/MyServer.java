package com.jakub.myjmx;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.jakub.myjmx.controller.Controller;
import com.jakub.myjmx.mbean.UpdateListener;

public class MyServer 
{
	public static void main(String[] args) throws Exception {

		//Create listener
		UpdateListener ul = new UpdateListener();
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		Server server = new Server(8080);
		server.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", Controller.class.getCanonicalName());
		
		server.start();
		server.join();
	}
}
