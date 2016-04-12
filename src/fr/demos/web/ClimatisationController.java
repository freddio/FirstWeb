package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimatisationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean erreur = false;
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if (action != null && action.equals("enregistrer")) {
			String appareil = request.getParameter("appareil");
			String temperatureStr = request.getParameter("temperature");
			String pressionStr = request.getParameter("pression");
			String humiditeStr = request.getParameter("humidite");
			// pour repeupler le formulaire en cas d'erreur
			request.setAttribute("temperature", temperatureStr);
			request.setAttribute("pression", pressionStr);
			request.setAttribute("appareil", appareil);
			request.setAttribute("humidite", humiditeStr);
			// conversion
			double temperature = 0;
			double pression = 0;
			int humidite = 0;

			try {
				temperature = Double.parseDouble(temperatureStr);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("temperatureErreur", "nombre incorrect");
			}
			try {
				pression = Double.parseDouble(pressionStr);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("pressionErreur", "nombre incorrect");
			}
			try {
				humidite = Integer.parseInt(humiditeStr);
			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("humiditeErreur", "nombre incorrect");
			}

			// validation
			if (appareil == null || appareil.equals("")) {
				erreur = true;
				request.setAttribute("appareilErreur", "nom d'appareil obligatoire");
			}

			if (!erreur) {
				Climatisation clim = new Climatisation(temperature, pression, humidite, appareil);
				try {
					
					ClimatisationDAO dao = new SQLClimatisationDAO();
					dao.sauve(clim);
					rd = request.getRequestDispatcher("/successClimatisation.jsp");
				} catch (Exception e) {
				
					e.printStackTrace();
					request.setAttribute("sauvegardeErreur", e.getMessage());
					rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
				}			
			}

		}
		rd.forward(request, response);
	}
}
