<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored= "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>contact page</title>
  </head>
  <body>
  
  <div class="card-container text-center m-10 p-10">
  
  <h1>${Header}</h1>
  <p>${desc }</p>

    <form action="poccessForm" method="post">
		  <div class="form-group row">
		    <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">Name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control form-control-sm" id="userName" 
		      placeholder="use-name"
		      name="name">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="colFormLabel" class="col-sm-2 col-form-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" class="form-control" id="userEmail" 
		      placeholder="user-email"
		      name="email">
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">password</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control form-control-lg" id="userPassword" 
		      placeholder="user-password"
		      name="password">
		    </div>
		  </div>
		 <div>
		 <button class="btn btn-success" type="submit">sing-up</button>
		 </div>
</form>
  </div>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>