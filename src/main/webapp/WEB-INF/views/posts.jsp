<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container mt-3">
		<strong>Welcome ${user.name}!</strong>
		<form class="mb-3" action="<c:url value='/post/create'/>"
			method="post">
			<div class="form-group mt-2">
				<label for="content">Share something:</label>
				<textarea class="form-control" name="content" required></textarea>
			</div>
			<button type="submit" class="btn btn-success mt-2">Post</button>
		</form>
		<h4>Latest Posts:</h4>
		<c:forEach var="post" items="${posts}">
			<div class="card border-dark mb-3">
				<div class="row">
					<div class="col">
						<div class="card-header">
							<div class="row align-items-center">
								<div class="col-1">
									<img src="<c:url value='/images/default-profile-picture.png'/>"
										class="img-thumbnail" alt="Profile Picture">
								</div>
								<div class="col">
									<h6 class="lead">Nathan Pezzotti:</h6>
									<small class="text-muted">${post.createdAt}</small>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="card-text">${post.content}</div>
						<a href="<c:url value='/post?id=${post.id}'/>">3 Comments</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
