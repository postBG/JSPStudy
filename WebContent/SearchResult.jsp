<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-condensed">
  <tr>
    <th id="name_header">이름</th>
    <th id="email_header">Email</th>
  </tr>
	<c:forEach var="recipient" items="${searchResult}">
	  <tr>
	    <td class="name_col">${recipient.name}</td>
	    <td class="email_col">${recipient.email}</td>
	  </tr>
	</c:forEach>
</table>