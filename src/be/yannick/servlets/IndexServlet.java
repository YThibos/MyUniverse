package be.yannick.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "indexservlet", description = "Main welcome page servlet", urlPatterns = { "/index.htm" })
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("logout") != null) {
			request.getSession().removeAttribute("user");
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

}
