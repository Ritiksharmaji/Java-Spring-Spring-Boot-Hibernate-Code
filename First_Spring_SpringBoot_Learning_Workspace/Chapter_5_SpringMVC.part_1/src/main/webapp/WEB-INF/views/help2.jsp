<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<% 
		String name = (String) request.getAttribute("name");
		String roll = (String) request.getAttribute("roll");
		 %>
<h1>welcome to help page</h1>
<h2>name : <%= name %>  </h2>
<h2>id: <%=  roll %> </h2>

		


</body>
</html>