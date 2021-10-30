<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="User List">
	<div class="container mt-2">
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="container text-left">
	
			<a href="new" 
				class="btn btn-success">
				Add New User
			</a>
		</div>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.country}" /></td>
						<td>
							<a href="edit?id=<c:out value='${user.id}' />">
								Edit
							</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out value='${user.id}' />">
								Delete
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:base>