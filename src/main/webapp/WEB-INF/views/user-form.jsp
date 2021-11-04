<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="User Form">
	<div class="container col-md-5 mt-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="edit" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="new" method="post">
				</c:if>
				<div>
					<h2>
						<c:if test="${user != null}">
	           			Edit User
	           		</c:if>
						<c:if test="${user == null}">
	           			Add New User
	           		</c:if>
					</h2>
				</div>
				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				<div class="form-group">
					<label for="name">Name</label>
					<input type="text"
						value="<c:out value='${user.name}' />" 
						class="form-control" 
						name="name" 
						required />
				</div>
				<div class="form-group">
					<label for="email">Email</label> 
					<input type="text"
						value="<c:out value='${user.email}' />" 
						class="form-control"
						name="email"
						required />
				</div>
				<div class="form-group">
					<label for="password">Password</label> 
					<input type="text"
						value="<c:out value='${user.password}' />" 
						class="form-control"
						name="password"
						required />
				</div>
				<div class="form-group">
					<label for="">Country</label> 
					<input type="text"
						value="<c:out value='${user.country}' />" 
						class="form-control"
						name="country"
						required />
				</div>
				<button type="submit" class="btn btn-success mt-2">Save</button>
				</form>
			</div>
		</div>
	</div>
</t:base>
