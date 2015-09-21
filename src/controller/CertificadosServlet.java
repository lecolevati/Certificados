package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CertificadosServlet
 */
@WebServlet("/certificados")
public class CertificadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CertificadosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String raAluno = request.getParameter("raaluno");
		
		byte[] bytes = null;
		ServletContext context = getServletContext();
		
		String fundo = context.getRealPath("/WEB-INF/images/fundo.png");
		
		try {
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("RA", raAluno);
			parametros.put("Fundo", fundo);
//			JasperReport relatorioJasper = (JasperReport) JRLoader
//					.loadObjectFromFile(context
//							.getRealPath("/WEB-INF/reports/AcadHistoricoLimpo.jasper"));
//			bytes = JasperRunManager.runReportToPdf(relatorioJasper,
//					parametros, new GenericoDao().getConnection());
//			bytes = null;
		} catch (SQLException e){// | JRException e) {
			e.printStackTrace();
		} finally {
			if (bytes != null) {
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} else {
				PrintStream tela = new PrintStream(response.getOutputStream());
				tela.println("<HTML><BODY>");
				tela.println("<script>alert('Sem certificados para ==> RA = '"+raAluno+");history.back();</script>");
				tela.println("<BR><P>");
				tela.println("</HTML></BODY>");
			}
		}
	}
}
