package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Palestra;
import persistence.PalestrasDao;

/**
 * Servlet implementation class PalestrasServlet
 */
@WebServlet("/palestras")
public class PalestrasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PalestrasServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String raAluno = request.getParameter("raaluno");
		List<Palestra> lista = new ArrayList<Palestra>();
		try {
			PalestrasDao pDao = new PalestrasDao();
			lista = pDao.consultaPalestraPorAluno(raAluno);
		} catch (SQLException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("erro", erro);
			request.setAttribute("listaPalestras", lista);
			RequestDispatcher view = request
					.getRequestDispatcher("palestras.jsp");
			view.forward(request, response);
		}
	}

}
