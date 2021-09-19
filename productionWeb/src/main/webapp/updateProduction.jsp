<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import =  "com.ltts.productionWeb.model.*,com.ltts.productionWeb.dao.*,java.util.*"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% HttpSession sess = request.getSession();
	if(sess.getAttribute("email")!=null){%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	ProductionDao pd =new ProductionDao();
	List<Production> li = pd.displayProduction();
	Production p =null;
	for(Production newP: li)
	{
		if(newP.getProductionId() == id)
		{
			p = newP;
			break;
		}
	}
%>
<form action="./updateProduction">
Production ID <input type = "number" name = "productionId" value ="<%=p.getProductionId()%>"> <br><br>
Production Name <input type = "text" name = "prodName" value="<%=p.getProductionName()%>"><br><br>
Address <input type = "text" name = "address" value="<%=p.getAddress()%>"><br><br>
Starting Date <input type = "number" name = "startdate" value ="<%=p.getStartDate()%>"><br><br>
Owner Name <input type = "text" name = "owner" value ="<%=p.getOwnerName()%>"><br><br>

<input type = "submit" value = "Update">
</form>
<%} else{
	response.sendRedirect("login.html");}%>

</body>
</html>