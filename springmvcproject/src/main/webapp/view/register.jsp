<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTRATION FORM</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
function validateUser(a) {
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		document.getElementById("sp1").innerHTML=xmlhttp.responseText;
	}
	xmlhttp.open("post","checkuserinfo.do?q="+a,true);
	xmlhttp.send();
	
}



</script>
</head>
<td><a href="home.do">HOME</a></td>
  <body>
 
   <form:form method="post" action="regcode.do">
    <table align="center"  border="1">
    <tr><td>USERNAME</td> <td><form:input path="username" onblur="validateUser(this.value)"/><span id="sp1"></span> </td></tr>
<tr>
 <td>
  PASSWORD</td><td><form:input path="password"/> </td></tr>
<tr>
 <td>
  EMAIL</td> <td><form:input path="email" /> </td></tr>
 <tr>
 <td>
  PHONE</td> <td><form:input path="phone" /> </td></tr>
  
 <td align="left">
  <input type="submit" name="btnsubmit" value=" register " />
  </td>
   </tr>
   </table>
</form:form>
${key}
${key1}
        </body>

        </html>