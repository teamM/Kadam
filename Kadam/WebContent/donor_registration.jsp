<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kadam.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#datepicker1" ).datepicker();
    $( "#datepicker2" ).datepicker();
    $( "#datepicker3" ).datepicker();
  });
  
  function validateRegistrationForm(){
	  var numflag=0;
	  if (document.forms["registrationform"]["donor_name"].value==null || document.forms["registrationform"]["donor_name"].value=="")
	  	{
	  		document.getElementById("donor_name_error").innerHTML="<font color='red'>donor name cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_commitment"].value==null || document.forms["registrationform"]["donor_commitment"].value=="")
	  	{
	  		document.getElementById("donor_commitment_error").innerHTML="<font color='red'>donor commitment cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_address"].value==null || document.forms["registrationform"]["donor_address"].value=="")
	  	{
	  		document.getElementById("donor_address_error").innerHTML="<font color='red'>donor address cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_phone1"].value==null || document.forms["registrationform"]["donor_phone1"].value=="")
	  	{
	  		document.getElementById("donor_phone1_error").innerHTML="<font color='red'>donor phone no cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_bday"].value==null || document.forms["registrationform"]["donor_bday"].value=="")
	  	{
	  		document.getElementById("donor_bday_error").innerHTML="<font color='red'>donor bday cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_email1"].value==null || document.forms["registrationform"]["donor_email1"].value=="")
	  	{
	  		document.getElementById("donor_email1_error").innerHTML="<font color='red'>donor email id cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_workplace"].value==null || document.forms["registrationform"]["donor_workplace"].value=="")
	  	{
	  		document.getElementById("donor_workplace_error").innerHTML="<font color='red'>donor workplace cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_designation"].value==null || document.forms["registrationform"]["donor_designation"].value=="")
	  	{
	  		document.getElementById("donor_designation_error").innerHTML="<font color='red'>donor designation cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_pan"].value==null || document.forms["registrationform"]["donor_pan"].value=="")
	  	{
	  		document.getElementById("donor_pan_error").innerHTML="<font color='red'>donor Pan cannot be empty</font>";
	  		numflag++;
	  	}
	  if (document.forms["registrationform"]["donor_comments"].value==null || document.forms["registrationform"]["donor_comments"].value=="")
	  	{
	  		document.getElementById("donor_comments_error").innerHTML="<font color='red'>Comments cannot be empty</font>";
	  		numflag++;
	  	}
	  if(numflag==0){	  
		  return true;
	  }
	  else{	  
		  return false;
	  }
  }
  </script>

<body>

<%if(session.getAttribute("success")!=null){ %>
	<%=session.getAttribute("success") %>	
	To Register another user <a href="donor_registration.jsp">click here</a>
<% session.setAttribute("success", null);
session.invalidate();
}else { %>

<form action="DonorRegistrationController" name="registrationform" onsubmit="return validateRegistrationForm()">
<table cellspacing="2" cellpadding="8">
<%-- <tr>
<td><p:Label label="don_id"/></td>
<td><input type="text" name="donor_id"></td>
</tr>
 --%><tr>
<td><p:Label label="don_name"/></td>
<td><input type="text" name="donor_name"></td>
<td colspan="2"><span id="donor_name_error"></span></td>
</tr>
<%-- <tr>
<td><p:Label label="don_regdate"/></td>
<td><input type="text" name="donor_regdate" id="datepicker1"></td>
</tr>
 --%><tr>
<td><p:Label label="don_commitment"/></td>
<td><input type="text" name="donor_commitment"></td>
<td colspan="2"><span id="donor_commitment_error"></span></td>
</tr>
<tr>
<td><p:Label label="don_address"/></td>
<td><input type="text" name="donor_address"></td>
<td colspan="2"><span id="donor_address_error"></span></td>
</tr>
<tr>
<td><p:Label label="don_phone1"/></td>
<td><input type="text" name="donor_phone1"></td>
<td colspan="2"><span id="donor_phone1_error"></span></td>
</tr>
<tr>
<td><p:Label label="don_phone2"/></td>
<td><input type="text" name="donor_phone2"></td>
</tr>
<tr>
<td><p:Label label="don_bday"/></td>
<td><input type="text" name="donor_bday" id="datepicker2"></td>
<td colspan="2"><span id="donor_bday_error"></span></td>
</tr> 
<tr>
<td><p:Label label="don_anniv"/></td>
<td><input type="text" name="don_anniversary" id="datepicker3"></td>
</tr> 
<tr>
<td><p:Label label="don_email"/></td>
<td><input type="text" name="donor_email1"></td>
<td colspan="2"><span id="donor_email1_error"></span></td>
</tr> 
<tr>
<td><p:Label label="don_email2"/></td>
<td><input type="text" name="donor_email2"></td>
</tr> 
<tr>
<td><p:Label label="don_workplace"/></td>
<td><input type="text" name="donor_workplace"></td>
<td colspan="2"><span id="donor_workplace_error"></span></td>
</tr> 
<tr>
<td><p:Label label="don_designation"/></td>
<td><input type="text" name="donor_designation"></td>
<td colspan="2"><span id="donor_designation_error"></span></td>
</tr> 
<tr>
<td><p:Label label="don_pan"/></td>
<td><input type="text" name="donor_pan"></td>
<td colspan="2"><span id="donor_pan_error"></span></td>
</tr> 
<tr>
<td><p:Label label="don_comments"/></td>
<td><textarea rows="3" cols="10" name="donor_comments"></textarea></td>
<td colspan="2"><span id="donor_comments_error"></span></td>
</tr>  
<tr>
<td><p:Button name="buttonsubmit" type="submit" value="buttonreg"/></td>
</tr>
</table>
</form>
<%} %>
</body>
</html>