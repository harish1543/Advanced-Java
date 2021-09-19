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

MovieDao pd = new MovieDao();

List<Movie> movieList = pd.displayAllMovies();
%>

<table>
<tr>
<th>Movie ID</th>
<th>Movie Name</th>
<th>Hero Name</th>
<th>Heroine Name</th>
<th>Release Date</th>
<th>Language</th>
<th>Length</th>
<th>Movie Type</th>
<th>Production ID</th>
</tr>

<% for(Movie m: movieList) {%>
<tr>
<td><%=m.getMovieId() %></td>
<td><%=m.getMovieName() %></td>
<td><%=m.getHeroname() %></td>
<td><%=m.getHeroineName() %></td>
<td><%=m.getReleaseDate() %></td>
<td><%=m.getLanguage() %></td>
<td><%=m.getLength() %></td>
<td><%=m.getMovieType() %></td>
<td><%=m.getProductionId() %></td>
<td><a href = "deleteMovie.jsp?id=<%=m.getMovieId()%>">remove entry</a></td>
<%} %>
<%} else{
	response.sendRedirect("login.html");}%>

</table>
<br><br><br>
<a href = "home.html">Back to Home</a>
</body>
</html>