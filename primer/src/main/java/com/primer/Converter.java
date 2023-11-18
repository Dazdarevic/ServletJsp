package com.primer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/Converter")
public class Converter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("iznos");
    	int iznos = Integer.parseInt(input);
    	
    	//  Value
    	int eur = 117;
    	int usd = 108;
    	int km = 60;
    	int tryy = 7;
    	int rezultat = 0;
    	
    	String valuta = request.getParameter("valuta");
    	
    	
    	switch(valuta) {
    	case "eur":
    		rezultat = iznos / eur;
    		break;
		case "usd":
			rezultat = iznos / usd;		
		    break;
		case "km":
			rezultat = iznos / km;
			break;
		case "try":
			rezultat = iznos / tryy;
			break;
    	}
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	out.println(rezultat);
	}

}
