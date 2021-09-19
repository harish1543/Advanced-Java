<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import =  "com.ltts.productionWeb.model.*,com.ltts.productionWeb.dao.*,java.util.*"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Movie</title>
</head>
<body>
<% HttpSession sess = request.getSession();
	if(sess.getAttribute("email")!=null){%>
<%
	try{
	MovieDao pd = new MovieDao();
	int key = Integer.parseInt(request.getParameter("id"));
	if(pd.deleteMovie(key))
	{
		response.sendRedirect("viewProduction.jsp");
	}else{
		String errorMsg = "Deletion Failed";
		request.setAttribute("message", errorMsg);
		response.sendRedirect("error.jsp");
	}
	}catch(Exception e){
		System.out.println(e);
		String errorMsg = "Deletion Failed";
		request.setAttribute("message", errorMsg);
		response.sendRedirect("error.jsp");
	}
	
	

%>
<%} else{
	response.sendRedirect("login.html");}%>
</body>
</html>