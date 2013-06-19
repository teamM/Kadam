<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kadam.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function storeSessionVar(){
	
	}
</script>
<title>Insert title here</title>
</head>
<body>
<%System.out.println("printing from <a>" + request.getParameter("RNO")); %>
<p:readpdf/>
<c:redirect url="printReceipt.jsp"></c:redirect>
<!-- 
<form action="ReadPdfController" name='readpdf'>
<p:readpdf/>
<c:redirect url="printReceipt.jsp"></c:redirect>
</form>
-->
</body>
</html>