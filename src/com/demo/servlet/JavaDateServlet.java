package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class JavaDateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JavaDateServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/xml");
		String param1 = request.getParameter("param1"); // pending/optional
		
		Date date = new Date();
		
		long curDateString = (date).getTime();
		
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String dateText = df2.format(date);
        
		String responseXml = "<JavaDate>";
		responseXml += "<long>" + curDateString + "</long>";
		responseXml += "<text>" + dateText + "</text>";
		responseXml += "</JavaDate>";
	
		System.out.println("** SENDING xml:  = " + responseXml);
		PrintWriter out = response.getWriter();
		out.println(responseXml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("Hello World Get");
	}

}
