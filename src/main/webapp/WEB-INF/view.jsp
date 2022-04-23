<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="dashbaord">
		<a href ="/">Dashboard</a>
	</div>
	<div class="body">
		
		<p><c:out value="${language.name }"></c:out></p>
		<p><c:out value="${language.creator }"></c:out></p>
		<p><c:out value="${language.version }"></c:out></p>
		
	</div>
	<a href="/languages/${language.id}/edit/">Edit </a>
	
	
	<form action="/languages/${language.id}/delete" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
	</form>
	
	
</body>