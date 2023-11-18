package net.javaguides.valute.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.valute.dao.ValutaDAO;
import net.javaguides.valute.model.Valuta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ValutaServlet
 */
public class ValutaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ValutaDAO valutaDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValutaServlet() {
        this.valutaDAO = new ValutaDAO();
        
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertValuta(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteValuta(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			try {
				updateValuta(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				listaValuta(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
		private void listaValuta(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
			List<Valuta> listaValuta = valutaDAO.selectAll();
			request.setAttribute("listaValuta", listaValuta);
			
			jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("lista-valuta.jsp");
			dispatcher.forward(request, response);
		}
		private void updateValuta(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException, SQLException {
			int id = Integer.parseInt(request.getParameter("id"));
			String naziv = request.getParameter("naziv");
			String drzava = request.getParameter("drzava");
			String vrednost = request.getParameter("vrednost");
			
			Valuta valuta = new Valuta(id, naziv, drzava, vrednost);
			valutaDAO.updateValuta(valuta);
			response.sendRedirect("list");
		}
		private void deleteValuta(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException, SQLException {
			int id = Integer.parseInt(request.getParameter("id"));
			valutaDAO.deleteValuta(id);
			response.sendRedirect("list");
		}
		private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Valuta postojecaValuta = valutaDAO.selectValuta(id);
			jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("valuta-form.jps");
			request.setAttribute("valuta", postojecaValuta);
			dispatcher.forward(request, response);
		}
		private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("valuta-form.jps");
			dispatcher.forward(request, response);
		}
		private void insertValuta(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, ClassNotFoundException, SQLException {
			String naziv = request.getParameter("naziv");
			String drzava = request.getParameter("drzava");
			String vrednost = request.getParameter("vrednost");
			
			Valuta novaValuta = new Valuta(naziv, drzava, vrednost);
			valutaDAO.insertValuta(novaValuta);
			response.sendRedirect("list");
		}


}
