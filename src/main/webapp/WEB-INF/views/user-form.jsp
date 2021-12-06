<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container mt-5">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">Edit Profile</h4>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-3">
						<img src="<c:url value='/images/default-profile-picture.png'/>"
							class="img-thumbnail" alt="Profile Picture">
					</div>
					<div class="col">
						<form action="<c:url value='/user/edit?id=${userToEdit.id}'/>"
							method="post">
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
							<label for="formFile" class="form-label">Profile Picture</label>
							<input class="form-control" type="file" id="formFile">
							<button type="submit" class="btn btn-primary mt-2">Submit</button>
							<a href="<c:url value='/posts'/>" class="btn btn-secondary mt-2"
								role="button" aria-pressed="true">Cancel</a> <a
								href="<c:url value='/user/delete?id=${user.id}'/>"
								class="btn btn-danger mt-2" role="button" aria-pressed="true">Delete
								Account</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
