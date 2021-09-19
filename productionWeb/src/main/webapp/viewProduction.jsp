<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.ltts.productionWeb.model.*,com.ltts.productionWeb.dao.*,java.util.*" %>
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
	ProductionDao pd = new ProductionDao();
	List<Production> prodList = pd.displayProduction();
%>
<table>
<tr>
<th>Production ID</th>
<th>Production Name</th>
<th>Address</th>
<th>Starting Date</th>
<th>Owner</th>
<th>Update</th>
<th>Delete</th>
</tr>
<%for (Production p:prodList) {%>
<tr>
<td><%=p.getProductionId() %></td>
<td><%=p.getProductionName() %></td>
<td><%=p.getAddress() %></td>
<td><%=p.getStartDate() %></td>
<td><%=p.getOwnerName() %></td>
<td><a href = "updateProduction.jsp?id=<%=p.getProductionId()%>">Update Details</a>
<td><a href = "deleteProduction.jsp?id=<%=p.getProductionId()%>">remove entry</a>
</tr>
<%} %>
<%} else{
	response.sendRedirect("login.html");}%>
</table>
<br><br><br>
<a href = "home.html">Back to Home</a>
</body>
</html>