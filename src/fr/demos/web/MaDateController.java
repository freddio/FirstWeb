package fr.demos.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateController")
public class MaDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MaDateController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// d représente le model
		Date d = new Date();
		
		Climatisation clim1 = new Climatisation(24,1010,30,"R203");
		
		// transfert du model
		request.setAttribute("dateDuJour", d);
		request.setAttribute("clim1", clim1);
		
		// appel de la vue
		RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
		rd.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
