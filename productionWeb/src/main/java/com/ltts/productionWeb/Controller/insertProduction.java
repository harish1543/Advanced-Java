package com.ltts.productionWeb.Controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltts.productionWeb.dao.ProductionDao;
import com.ltts.productionWeb.model.Production;

/**
 * Servlet implementation class insertProduction
 */
@WebServlet("/insertProduction")
public class insertProduction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertProduction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession sess = request.getSession();
		
		if(sess.getAttribute("email")!=null) {
		
			int id = Integer.parseInt(request.getParameter("productionId"));
			String name = request.getParameter("prodName");
			String address = request.getParameter("address");
			int startdate = Integer.parseInt(request.getParameter("startdate"));
			String owner = request.getParameter("owner");
			
			Production p = new Production(id, name, address, startdate, owner);
			
			ProductionDao pd = new ProductionDao();
			
			boolean b = true;
			
			try{
				 b = pd.insertProduction2(p);
			}catch(Exception e)
			{
				System.out.println(e+"\nOperation Failed");
			}finally {
				RequestDispatcher rd = null;
				if(b)
				{
					String errorMsg = "Insertion Successful!";
					request.setAttribute("message", errorMsg);
					rd = request.getRequestDispatcher("success.jsp");
				}else {
					String errorMsg = "Insertion Failed";
					request.setAttribute("message", errorMsg);
					rd = request.getRequestDispatcher("error.jsp");
				}
				rd.forward(request, response);
			}
		}else {
			response.sendRedirect("login.html");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
