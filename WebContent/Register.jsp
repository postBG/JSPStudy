<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/lib/jquery-2.2.0.js"></script>
<script src="js/input_validation.js"></script>
<link rel="stylesheet" href="stylesheets/registerStyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<title>Register Page</title>
</head>
<body>
  <nav class="navbar navbar-light bg-faded" id="register_nav">
    <ul class="nav navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/email/list.do">List Page</a>
      </li>
    </ul>
  </nav>
    
  <div id="recipient_info_form">
    <h1 id="form_name">Register Recipient</h1>
	  <form id="recipient_info">
	    <div id="success_msg" role="alert"></div>
	    <div class="input-group">
	      <span class="input-group-addon" id="name_title">Name</span>
	      <input type="text" class="form-control" id="name" name="name" placeholder="Recipient's name" >
	    </div>
	    <div class="input-group">
	      <input type="text" class="form-control" id="email" placeholder="Recipient's email" name="email">
	      <span class="input-group-addon" id="email_title">@mysite.com</span>
	    </div>
	    
	    <input type="submit" value="저장" class="btn btn-default" id="form_submit">
	    <div id="name_error" class="alert alert-warning" role="alert"></div>
	    <div id="email_error" class="alert alert-warning" role="alert"></div>
	  </form>
  </div>
  
</body>
</html>