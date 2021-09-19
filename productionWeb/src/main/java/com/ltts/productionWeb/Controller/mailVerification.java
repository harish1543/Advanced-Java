package com.ltts.productionWeb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltts.productionWeb.model.Member;

/**
 * Servlet implementation class mailVerification
 */
@WebServlet("/mailVerification")
public class mailVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String Email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String location = request.getParameter("location");
		String pass = request.getParameter("pass");
		SendMail sm = new SendMail();
		String code = sm.randomCode();
		Member m = new Member(name,Email,mobile,location,pass,code);
		
		PrintWriter out = response.getWriter();
		
		
		//String code = sm.code;
		boolean test = sm.sendMail(m);
		   if(test){
               HttpSession session  = request.getSession();
               session.setAttribute("authcode", m);
               response.sendRedirect("verifyCode.jsp");
           }else{
      		  out.println("Failed to send verification email");
      	   }
		//doGet(request, response);
	}

}
