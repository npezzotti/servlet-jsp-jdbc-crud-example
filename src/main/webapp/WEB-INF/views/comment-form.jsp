<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="Comment">
	<div class="container col-md-5 mt-5">
		<div class="card">
			<div class="card-body">
				<form action="comment?id=<c:out value='${comment.id}' />" method="post">
					<h2>Comment</h2>
					<div class="form-group">
						<label for="name">Name</label>
						<input type="text"
							value="<c:out value='${userToEdit.name}' />"
							class="form-control"
							name="name"
							required />
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="text"
							value="<c:out value='${userToEdit.email}' />"
							class="form-control"
							name="email"
							required />
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password"
							value="<c:out value='${userToEdit.password}' />"
							class="form-control"
							name="password"
							required />
					</div>
					<button type="submit" class="btn btn-success mt-2">Submit</button>
					<a href="delete?id=<c:out value='${user.id}' />">Delete Account</a>
				</form>
			</div>
		</div>
	</div>
</t:base>