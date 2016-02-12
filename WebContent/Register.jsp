<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lib/jquery-2.2.0.js"></script>
<script src="js/input_validation.js"></script>
<title>Register Page</title>
</head>
<body>
  <a href="http://localhost:8080/email/list">List Page</a>
  
  <form id="recipient_info">
    <p>고객의 정보를 입력해주세요.</p>
    Name: <input type="text" name="username" id="name"><br>
    Email: <input type="text" name="email" id="email"><br>
    <input type="submit" value="저장">
    <div id="success_msg"></div>
    <div id="name_error"></div>
    <div id="email_error"></div>
  </form>
</body>
</html>