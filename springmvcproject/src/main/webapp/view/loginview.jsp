<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.List" %>  
    <%@page import="java.util.Iterator"%>
    <%@page import="mod.User" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>


<table border="1">
<tr><th>username</th><th>email</th><th>status</th><th>phone</th></tr>

<%
if(request.getAttribute("key")!=null)
{
	List lst = (List)request.getAttribute("key");
	Iterator it = lst.iterator();
	while(it.hasNext()){
		User u = (User)it.next(); %>
		<tr><td> <%=u.getUsername() %></td><td><%=u.getEmail() %></td><td> <%=u.getStatus() %></td><td> <%=u.getPhone() %></td>
		
		</tr>
		
<% 	}
}


%>
</table>

</body>
</html>