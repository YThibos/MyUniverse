package be.yannick.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.yannick.dao.UserDAO;
import be.yannick.entities.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login.htm")
public class UserLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/login.jsp";
	private static final String REDIRECT_URL = "%s/index.htm";
	
	
	
	private static final UserDAO userDAO = new UserDAO();

	@Resource(name = UserDAO.JDNI_NAME)
	void setDataSource(DataSource dataSource) {
		userDAO.setDataSource(dataSource);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> errors = new HashMap<>();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// Check validity of given Strings
		if (username != null && password != null && !username.equals("") && !password.equals("")) {
			User user = userDAO.findUser(username);
			
			if (user != null && user.getPassword().equals(password)) {
				request.getSession().setAttribute("user", user);
			}
			else {
				errors.put("user", "User/password combination not found");
			}
		}
		else {
			errors.put("input", "Invalid input");
		}
		
		if (errors.isEmpty()) {
			response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
		}
		else {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
	}

}
