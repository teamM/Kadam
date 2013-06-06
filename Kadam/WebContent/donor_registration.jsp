<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kaps.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DonorRegistrationController">
<table cellspacing="2" cellpadding="8">
<tr>
<td><p:Label label="don_id"/></td>
<td><input type="text" name="donor_id"></td>
</tr>
<tr>
<td><p:Label label="don_name"/></td>
<td><input type="text" name="donor_name"></td>
</tr>
<tr>
<td><p:Label label="don_regdate"/></td>
<td><input type="text" name="donor_regdate"></td>
</tr>
<tr>
<td><p:Label label="don_commitment"/></td>
<td><input type="text" name="donor_commitment"></td>
</tr>
<tr>
<td><p:Label label="don_address"/></td>
<td><input type="text" name="donor_address"></td>
</tr>
<tr>
<td><p:Label label="don_phone1"/></td>
<td><input type="text" name="donor_phone1"></td>
</tr>
<tr>
<td><p:Label label="don_phone2"/></td>
<td><input type="text" name="donor_phone2"></td>
</tr>
<tr>
<td><p:Label label="don_bday"/></td>
<td><input type="text" name="donor_bday"></td>
</tr> 
<tr>
<td><p:Label label="don_anniv"/></td>
<td><input type="text" name="don_anniversary"></td>
</tr> 
<tr>
<td><p:Label label="don_email"/></td>
<td><input type="text" name="donor_email"></td>
</tr> 
<tr>
<td><p:Label label="don_email2"/></td>
<td><input type="text" name="donor_email2"></td>
</tr> 
<tr>
<td><p:Label label="don_workplace"/></td>
<td><input type="text" name="donor_workplace"></td>
</tr> 
<tr>
<td><p:Label label="don_designation"/></td>
<td><input type="text" name="donor_designation"></td>
</tr> 
<tr>
<td><p:Label label="don_pan"/></td>
<td><input type="text" name="donor_pan"></td>
</tr> 
<tr>
<td><p:Label label="don_comments"/></td>
<td><textarea rows="3" cols="10" name="donor_comments"></textarea></td>
</tr>  
<tr>
<td><p:Button name="buttonsubmit" type="submit" value="buttonreg"/></td>
</tr>
</table>
</form>
</body>
</html>