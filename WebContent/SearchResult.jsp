<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-condensed">
  <tr>
    <th>이름</th>
    <th>Email</th>
  </tr>
	<c:forEach var="recipient" items="${searchResult}">
	  <tr>
	    <td>${recipient.name}</td>
	    <td>${recipient.email}</td>
	  </tr>
	</c:forEach>
</table>