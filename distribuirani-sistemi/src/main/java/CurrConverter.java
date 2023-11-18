

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CurrencyConverter")
public class CurrConverter extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("iznos");
    	int iznos = Integer.parseInt(input);
    	
    	//  Value
    	int eur = 117;
    	int usd = 108;
    	int km = 60;
    	int tryy = 7;
    	int rezultat = 0;
    	String pom="";
    	
    	String valuta = request.getParameter("valuta");
    	switch(valuta) {
    	case "eur": 
    		pom = "evrima";
    		rezultat = iznos / eur;
    		break;
		case "usd":
			pom = "dolarima";
			rezultat = iznos / usd;		
		    break;
		case "km":
			pom = "markama";
			rezultat = iznos / km;
			break;
		case "try":
			pom = "lirama";
			rezultat = iznos / tryy;
			break;
    	}
//		response.setContentType("text/html");
//    	PrintWriter out = response.getWriter();
//    	out.println(rezultat);
//    	out.close();
    	
//    	request.setAttribute("result", rezultat);
//    	request.getRequestDispatcher("result.jsp").forward(request, response);
    	
    	response.sendRedirect("index.jsp?q=" + "Iznos u dinarima: "+iznos + "<br>"+"Iznos u " + pom +": "+rezultat);
    	
	}

	

}
