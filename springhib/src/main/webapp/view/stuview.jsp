<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.shiv.model.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<%String s1 = request.getAttribute("btnKey")==null? "insert":"update"; %>
<form:form action="stucode.do" method="post" name="abc">
 Roll no <form:input path="rno" /> <br>
 name<form:input path="name" /> <br>

<input type="submit" name="btnsubmit" value="<%=s1 %>" /><br>

</form:form>
${key}
<BR>
<table border ="1">
<tr><th>Rno</th><th>Name</th></tr>
<%
if (request.getAttribute("key1")!=null)
{
	List lst=(List)request.getAttribute("key1");
	Iterator it = lst.iterator();
	while(it.hasNext())
	{
		Student s=(Student)it.next();%>
		<tr><td><%=s.getRno() %></td><td> <%=s.getName() %></td>
		<td> <a href ="stuedit.do?q=<%=s.getRno() %>">Edit</a></td><td> <a href ="studel.do?g=<%=s.getRno() %>">Delete</a></td></tr>

		
	<% }

}
%>



</table>
</body>