<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lib/jquery-2.2.0.js"></script>
<script src="js/list_up_service.js"></script>
<title>List User Information</title>
</head>
<body>
  <a href="http://localhost:8080/email/register.do">Register Page</a>
  
  <form id="search">
    <div>
      <label for="search">Search</label>
      <input type="text"  name="search_word" id="search_word">
      <input type="submit" value="Go!">
      <div id="search_result">
      </div>
    </div>
  </form>
  
  <div id="default_list">
	  <table>
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