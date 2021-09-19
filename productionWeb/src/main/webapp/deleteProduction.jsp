<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import =  "com.ltts.productionWeb.model.*,com.ltts.productionWeb.dao.*,java.util.*"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Production</title>
</head>
<body>
<% HttpSession sess = request.getSession();
	if(sess.getAttribute("email")!=null){%>
<%
	try{
	ProductionDao pd = new ProductionDao();
	int key = Integer.parseInt(request.getParameter("id"));
	if(pd.deleteProduction(key))
	{
		response.sendRedirect("viewProduction.jsp");
	}else
	{
		String errorMsg = "Deletion Failed";
		request.setAttribute("message", errorMsg);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
		//response.sendRedirect("error.jsp");	
	}
	}catch(Exception e){
		String errorMsg = "Deletion Failed";
		request.setAttribute("message", errorMsg);
		response.sendRedirect("error.jsp");
		System.out.println(e);
		
	}
%>
<%} else{
	response.sendRedirect("login.html");}%>
</body>
</html>