<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kadam.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--    For auto complete  -->
<link rel="stylesheet" type="text/css" href="Styles/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery.autocomplete.js"></script> 
<!--                       -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ReceiptDateVersionController">
<table>
<tr>
<td>Generate Reports :</td>
</tr>
<tr>
<td><p:Label label="donor"/></td>
<td>
<input type="text" id="donor" name="donor"/>
<script>
$("#donor").autocomplete("getquery.jsp");
</script>
</td>
<td colspan="2"><span id="donornameerror"></span></td>
</tr>
<tr>
<td>From Date : </td>
<td><input type="text" name="from_date"></td>
</tr>
<tr>
<td>To Date :</td>
<td><input type="text" name="to_date"></td>
</tr>
<tr>
<td><input type="submit" value="SUBMIT"></td>
</tr>
</table>
</form>
</body>
</html>