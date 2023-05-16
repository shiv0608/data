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
<td><a href="home.do">HOME</a></td>
                
<body>
<form:form method="post" action="admincode.do">
 username <form:input path="username" /> <br><br>
  password<form:password path="password"/> <br><br>
  <input type="submit" name="btnsubmit" value="Login" />

</form:form>

${key}

</body>
</html>