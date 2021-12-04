<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container mt-2">
		<div class="container mt-2">
			<form class="mb-3" action="post/create" method="post">
				<p>Welcome ${user.name}!</p>
				<div class="form-group">
					<label for="content">Share something:</label>
					<textarea class="form-control" name="content" required>
				</textarea>
				</div>
				<button type="submit" class="btn btn-success mt-2">Post</button>
			</form>
			<h3>Latest Posts:</h3>
			<hr />
			<c:forEach var="post" items="${posts}">
				<div class="container mt-3">
					<div class="row">
						<div class="container">
							<div class="">
								<div class="">
									<img src="/images/default-profile-picture.png"
										class="" alt="Profile Picture">
								</div>
								<div class="">
									<div class="title h5">
										<a href="#"><b></b></a>${post.id} User: ${post.userId} posted:
									</div>
									<h6 class="text-muted">${post.createdAt}</h6>
								</div>
							</div>
							<p>${post.content}</p>
							<a href="${pageContext.request.contextPath}/post?id=${post.id}">View Post</a>
						</div>
					</div>
				</div>
				<hr />
			</c:forEach>
		</div>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
