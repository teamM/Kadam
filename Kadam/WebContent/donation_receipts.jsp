<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kaps.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function function_registerdonor() {
	 w = window.open('donor_registration.jsp','','width=500,height=500');
	 w.focus();
}
</script>
</head>
<body>
<table cellspacing="2" cellpadding="8">
<tr>
<td><p:Label label="rvn"/></td>
<td><input type="text" name="receiptvoucherno"></td>
</tr>
<tr>
<td><p:Label label="donor"/></td>
<td><input type="text" name="donor"></td>
</tr>
<tr>
<td><p:Label label="collectionmode"/></td>
<td><input type="text" name="collectionmode"></td>
</tr>
<tr>
<td><p:Label label="fundname"/></td>
<td><input type="text" name="fundname"></td>
</tr>
<tr>
<td><p:Label label="date"/></td>
<td><input type="text" name="date"></td>
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
</body>
</html>