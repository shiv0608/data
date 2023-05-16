<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION FORM</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<td><a href="home.do">HOME</a></td>
  <body>
  
   <form:form method="post" action="editsave.do">
  <form:input type="hidden" path="username" /> <br><br>
  <form:input type="hidden" path="password"/> <br><br>
  <form:input type="hidden" path="email" /> <br><br>
  <form:input type="hidden"  path="phone" /> <br><br>
  <form:password type="hidden" value="1" path="status"/> <br><br>
<h1>Are you sure you want to update</h1>
  <input type="submit" name="btnsubmit" value="Approve" />
</form:form>
${key}
        </body>

        </html>