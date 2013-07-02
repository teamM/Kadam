<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="com.kadam.dao.impl.ReceiptgenerationDAO"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kaps.tld"%>
    <%@taglib prefix="p1" uri="/WEB-INF/kadam.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
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
<style>

</style>
<script type="text/javascript">
function function_registerdonor() {
	 w = window.open('donor_registration.jsp','','width=500,height=500');
	 w.focus();
}

function addDate(){
	date = new Date();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var year = date.getFullYear();
	
	if (document.getElementById('date').value == ''){
		document.getElementById('date').value = year + '-' + month + '-' + day;
	}
}
</script>
</head>
<body onload="addDate()">
<form action="ReceiptGenerationController">
<table cellspacing="2" cellpadding="8">
<tr>
<td><p:Label label="receiptno"/></td>
<td><p:ReceiptNO/></td>
</tr>
<tr>
<td><p:Label label="donor"/></td>
<td>
<input type="text" id="donor" name="donor"/>
<script>
$("#donor").autocomplete("getquery.jsp");
</script>
</td>

</tr>
<tr>
<td><p:Label label="collectionmode"/></td>
<td>
<select name = "collectionmode">
<option value="cash">cash</option>
<option value="cheque">cheque</option>
</select>
</td>
</tr>
<tr>
<td><p:Label label="fundname"/></td>
<td><input type="text" name="fundname"></td>
</tr>
<tr>
<td><p:Label label="date"/></td>
<td><input type="text" name="date" id="date" readonly="readonly"></td>
</tr>
<tr>
<td><p:Label label="amount"/></td>
<td><input type="text" name="amount"></td>
</tr>
<tr>
<td><p:Label label="details"/></td>
<td><input type="text" name="details"></td>
</tr>
<tr>
<td><p:Button name="buttonaccept" type="submit" value="buttonvalue"/></td>
</tr>
<tr>
<td><c:out value=" For new donor "></c:out><a onclick="function_registerdonor()"> CLICK HERE </a></td>
</tr>
</table>
</form>
</body>
</html>
