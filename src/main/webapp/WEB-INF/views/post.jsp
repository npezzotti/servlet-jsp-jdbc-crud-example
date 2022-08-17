<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container mt-3">
		<div class="card border-dark mb-3">
			<div class="row">
				<div class="col">
					<div class="card-header">
						<div class="row align-items-center">
							<div class="col-sm-1">
								<img src="<c:url value='/images/default-profile-picture.png'/>"
									class="img-thumbnail" alt="Profile Picture">
							</div>
							<div class="col">
								<h6 class="lead">${post.user.name}</h6>
								<small class="text-muted">${post.createdAt}</small>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="card-body">
					<div class="card-text">${post.content}</div>
					<a href="<c:url value='post/edit?id=${post.id}'/>">Edit Post</a> <a
						href="<c:url value='post/delete?id=${post.id}'/>">Delete Post</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h4>${post.comments.size()}&nbsp;Comment(s):</h4>
			</div>
		</div>
		<hr />
		<c:forEach var="comment" items="${post.comments}">
			<div class="card mb-3">
				<div class="row">
					<div class="col">
						<div class="card-header">
							<div class="row align-items-center">
								<div class="col-sm-1">
									<img src="<c:url value='/images/default-profile-picture.png'/>"
										class="img-thumbnail" alt="Profile Picture">
								</div>
								<div class="col">
									<h6 class="lead">${comment.user.name}</h6>
									<small class="text-muted">${comment.createdAt}</small>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="card-body">
						<div class="card-text">${comment.content}</div>
						<a href="<c:url value='/comment/delete?id=${comment.id}'/>">Delete
							Comment</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<form class="mb-3" action="<c:url value='/comment/create'/>"
			method="post">
			<div class="form-group">
				<label for="content">Comment:</label>
				<textarea class="form-control" name="content" required></textarea>
				<input type="hidden" name="postId" value="${post.id}">
				<button type="submit" class="btn btn-success mt-2">Send</button>
			</div>
		</form>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
