<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container col-md-5 mt-5">
		<div class="card">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/user/edit?id=${userToEdit.id}" method="post">
					<h2>Edit User</h2>
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							value="${userToEdit.name}" class="form-control" name="name"
							required />
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input type="text"
							value="${userToEdit.email}" class="form-control" name="email"
							required />
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							value="${userToEdit.password}" class="form-control"
							name="password" required />
					</div>
					<button type="submit" class="btn btn-primary mt-2">Submit</button>
					<a href="${pageContext.request.contextPath}/posts"
						class="btn btn-secondary mt-2" role="button" aria-pressed="true">Cancel</a>
					<a href="${pageContext.request.contextPath}/user/delete?id=${user.id}" class="btn btn-danger mt-2"
						role="button" aria-pressed="true">Delete Account</a>
				</form>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
