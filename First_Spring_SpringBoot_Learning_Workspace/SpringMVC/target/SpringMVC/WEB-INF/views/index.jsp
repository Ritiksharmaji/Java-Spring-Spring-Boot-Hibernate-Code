<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is first view pages</title>
</head>
<body>
<h1>welcome to first view page How can i help you ?</h1>

	<% // to get the data from controller using the scriptlet tag
	String name = (String)request.getAttribute("name");
	// to get number 
	 Integer nu=(Integer)request.getAttribute("number");
	// friends
	List<String> friends = (List<String>)request.getAttribute("friends");
	%>
	
<h1>name of author is: <%= name %></h1>
<h2>roll nu: <%=nu %></h2>
<h3>friends are: <%=friends %></h3>
<h3>Friends in other ways: 
		<% for(String s: friends){
		%>
		<h2><%=s %></h2>
		<% 
		}
		%>
</h3>
</body>
</html>