<%@page import="com.kadam.vo.ReceiptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*" %>
<%@page import="com.kadam.dao.impl.ReceiptgenerationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="p" uri="/WEB-INF/kadam.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KADAM RECEIPT</title>
</head>
<body>

<%ReceiptgenerationDAO dao = new ReceiptgenerationDAO();
List<ReceiptVO> receipt_list = new ArrayList<ReceiptVO>();
receipt_list = dao.printReceipt();
Iterator io_list = receipt_list.iterator();
%>
<table border='1'>
	<tr>
		<th>receipt no</th>
		<th>Date</th>
		<th>PDF</th>
		<th>Fund Name</th>
		<th>Details</th>
		<th>Donator</th>
		<th>Collection Mode</th>
		<th>Read File</th>
	</tr>

<%
while(io_list.hasNext()){	
	ReceiptVO vo = (ReceiptVO)io_list.next();
	String receiptno = vo.getReceipt_id() + "_" + vo.getReceipt_date();
	String pdf_name = "Donation_receipt_" + receiptno;
%>
	<tr>
		<td><%= vo.getReceipt_id() %></td>
		<td><%= vo.getReceipt_date() %></td>
		<td><%= pdf_name %></td>
		<td><%= vo.getFund_name() %></td>
		<td><%= vo.getDetails() %></td>
		<td><%= vo.getDonor_name() %></td>
		<td><%= vo.getCollection_mode() %></td>
		<td><a href="readPDF.jsp?&RNO=<%= receiptno %> " >open</a></td>
	</tr>
<%	
}
%>
</table>
</body>
</html>