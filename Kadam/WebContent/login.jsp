<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/kadam.tld" prefix="p"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p:Text text="logindetails"></p:Text>
</h2>
<form action="LoginController" method="post"> 
<table>
   <!-- <tr>
    <td colspan="3"><span id="loginerror" ></span></td>
   </tr> 
   -->
	<tr>
		<td>
		 <p:Label label="username"/>
		</td>
		<td><input type="text" name="username" id="username"></td>		 
	</tr>
	
	<tr>
		<td>
		 <p:Label label="password"/>
		</td>
		<td><input type="text" name="password" id="password"></td>		 
	</tr>
	</table>
	</form>
</body>
</html>