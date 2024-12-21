<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- to dis-able the ispageignore -->
 <%@page isELIgnored= "false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help page</title>
<style type="text/css">
.container-card{
text-align:center;
}
.heading{
color:red;
}
</style>

</head>
<body>
		<% /* commeting the code
		String name = (String) request.getAttribute("name");
		String roll = (String) request.getAttribute("roll");
		*/ %>
<h1>welcome to help page</h1>
<h2>name : 
 <%-- 	<%= name %>  --%>
 
 	 ${name}
</h2>
<h2>id: 
<%--   <%=  roll %>  --%>  ${roll}</h2>
<!-- to display the marks -->
<h1> 
<%--  ${marks }  --%>
</h1>
		<c:forEach var="item" items="${marks }">
		<h2>${item }</h2>
		</c:forEach>
		<div class="container-card">
		<h1 class="heading">this is by other ways</h1>
		<c:forEach var="item" items="${marks }">
		<h2><c:out value="${item }"></c:out></h2>
		</c:forEach>
		</div>
		


</body>
</html>