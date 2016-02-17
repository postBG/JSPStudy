<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lib/jquery-2.2.0.js"></script>
<script src="js/list_up_service.js"></script>
<link rel="stylesheet" href="stylesheets/listStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<title>List User Information</title>
</head>
<body>
  <nav class="navbar navbar-light bg-faded" id="register_nav">
    <ul class="nav navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/email/register.do">Register Page</a>
      </li>
    </ul>
  </nav>

  <form id="search">
    <div class="input-group">
      <input type="text"  name="search_word" id="search_word" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <input type="submit" value="Go!" class="btn btn-default">
      </span>
    </div>
    <div id="search_result">
    </div>
  </form>
  
  <div id="default_list">
	  <table class="table table-condensed">
	    <tr>
	      <th>이름</th>
	      <th>Email</th>
	    </tr>
	    <c:forEach var="recipient" items="${recipients}">
	      <tr>
	        <td>${recipient.name}</td>
	        <td>${recipient.email}</td>
	      </tr>
	    </c:forEach>
	  </table>
  </div>
  
</body>
</html>