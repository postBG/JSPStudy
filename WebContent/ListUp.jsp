<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List User Information</title>
</head>
<body>
  <a href="http://localhost:8080/email/Register.jsp">Register Page</a>
  <table>
    <tr>
      <th>이름</th>
      <th>Email</th>
    </tr>
    
    <c:forEach var="userInfo" items="${UserInfoList}">
      <tr>
        <td>${userInfo[0]}</td>
        <td>${userInfo[1]}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>