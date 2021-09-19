package com.ltts.productionWeb.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltts.productionWeb.dao.MemberDao;

/**
 * Servlet implementation class loginMember
 */
@WebServlet("/loginMember")
public class loginMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("email");
		String pass = request.getParameter("pass");
		MemberDao md = new MemberDao();
		RequestDispatcher rd =null;
		HttpSession sess = request.getSession();
		rd = request.getRequestDispatcher("login.html");
		try {
			if(md.verifyLogin(user,pass))
			{
				sess.setAttribute("email", user);
				request.setAttribute("name", user);
				rd = request.getRequestDispatcher("Welcome.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request,response);
		
		//doGet(request, response);
	}

}
