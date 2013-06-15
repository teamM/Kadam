<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.kadam.bo.AutoFillBo"%>
<%
	//AutoFillBo bo = new AutoFillBo();
System.out.println("in getuerryjsp hh");
	String query = request.getParameter("q");
	
	
	List<String> names = (List<String>)session.getAttribute("donor_names");

	Iterator<String> iterator = names.iterator();
	while(iterator.hasNext()) {
		String name = (String)iterator.next();
		out.println(name);
	}
%>