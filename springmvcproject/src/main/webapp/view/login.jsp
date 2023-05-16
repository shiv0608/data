<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<td><a href="home.do">HOME</a></td>
<body>
<form:form method="post" action="logincode.do">
                <table align="center"  border="1">
                <tr>
                        <td>
 username <form:input path="username" /> <br><br>
 </td>
 <td>
  password<form:password path="password"/> <br><br>
  </td>
  <td align="left">
  <input type="submit" name="btnsubmit" value="Login" />
   </td>
   </tr>
   

</form:form>
${key}
</body>
</html>