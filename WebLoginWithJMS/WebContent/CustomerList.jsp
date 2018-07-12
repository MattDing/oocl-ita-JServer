<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<form class="form-inline" action="/WebLoginWithJMS/CustomerServlet" method="post">
			<div class="form-group">
				<input size="16" type="hidden"
					value="insert" name="flag" > 
				<label class="label-middle">id</label>
				<input size="16" type="text"
					value="${id}" name="id"> 
				<label class="label-middle">name</label>
				<input size="16" type="text"
					value="${name}" name="name"> 
				<label class="label-middle">age</label>
				<input size="16" type="text"
					value="${age}" name="age"> 
				<label class="label-middle">password</label>
				<input size="16" type="text"
					value="${password}" name="password"> &nbsp;
				<button type="submit">insert</button>
			</div>
		</form>
	</div>
	<div class="row margin-top-20">
		<table class="table">
			<thead>
				<tr>
					<th class="seq">id</th>
					<th>name</th>
					<th>age</th>
					<th>password</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<c:forEach var="data" items="${CustomerList}" varStatus="loop">
				<tr>
					<td>${data.id}</td>
					<td>${data.name}</td>
					<td>${data.age}</td>
					<td>${data.password}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row">
		<form class="form-inline" action="/WebLoginWithJMS/CustomerServlet" method="post">
			<div class="form-group">
				<input size="16" type="hidden"
					value="delete" name="flag" > 
				<label class="label-middle">id</label>
				<input size="16" type="text"
					value="${id}" name="id"> 
				
				<button type="submit">delete</button>
			</div>
		</form>
	</div>
</body>
</html>