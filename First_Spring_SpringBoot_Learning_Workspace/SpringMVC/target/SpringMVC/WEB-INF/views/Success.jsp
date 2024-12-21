<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <!-- to dis-able the ispageignore -->
 <%@page isELIgnored= "false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success page</title>
</head>
<body>

<h1>${Header}</h1>
  <p>${desc }</p>
<hr>
<h1>${user_name}</h1>
<h1>${ user_password}</h1>
<h1>${ user_email}</h1>
<h1>------- other ways-----------</h1>
<h1>${msg }</h1>
<h1>---------------------------------</h1>
<hr>
<h2>${user.id }</h2>
<h2>${user.name }</h2>
<h2>${user.email }</h2>
<h2>${user.password }</h2>
<h2>${userdetails.password }</h2>

</body>
</html>