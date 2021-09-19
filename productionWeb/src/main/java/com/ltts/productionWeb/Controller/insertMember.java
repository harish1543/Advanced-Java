package com.ltts.productionWeb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltts.productionWeb.dao.MemberDao;
import com.ltts.productionWeb.model.Member;

/**
 * Servlet implementation class insertMember
 */
@WebServlet("/insertMember")
public class insertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertMember() {
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
		/*String name = request.getParameter("name");
		String Email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String location = request.getParameter("location");
		String pass = request.getParameter("pass");
		
		Member m = new Member(name,Email,mobile,location,pass);*/
		MemberDao md = new MemberDao();
        try {
            
            HttpSession session = request.getSession();
            Member m= (Member) session.getAttribute("authcode");
            
            String code = request.getParameter("authcode");
            
            //SendMail sm = new SendMail();
            
            if(code.equals(m.getCode())){
        		RequestDispatcher rd = null;
        		rd = request.getRequestDispatcher("register.html");
        		if(md.insertMember(m))
        			{
        				rd = request.getRequestDispatcher("login.html");
        			} 
        		rd.forward(request, response);
            }else{
            	PrintWriter out = response.getWriter();
                out.println("Incorrect verification code");
                response.sendRedirect("Registration.html");
            }
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
		
		
		/*MemberDao md = new MemberDao();
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("register.html");
		try {
			if(md.insertMember(m))
			{
				rd = request.getRequestDispatcher("login.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd.forward(request, response);
		//doGet(request, response);*/

}
}
