<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>
  <a href="http://localhost:8080/email/list">List Page</a>
  
  <form action="register" method="GET">
    UserName: <input type="text" name="username"><br>
    Email: <input type="text" name="email"><br>
    <input type="submit" value="저장"> 
  </form>
</body>
</html>