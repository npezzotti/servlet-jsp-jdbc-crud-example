<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="../fixtures/head.jsp" />
<body>
	<jsp:include page="../fixtures/header.jsp" />
	<div class="container mt-2">
		<div class="container mt-3">
			<div class="row">
				<div class="container">
					<div class="">
						<div class="">
							<img src="/images/default-profile-picture.png" class=""
								alt="Profile Picture">
						</div>
						<div class="">
							<div class="title h5">
								<a href="#"><b></b></a>${post.id} User: ${post.userId} posted:
							</div>
							<h6 class="text-muted">${post.createdAt}</h6>
						</div>
					</div>
					<p>${post.content}</p>
					<a href="${pageContext.request.contextPath}/post/edit?id=${post.id}" class="btn btn-primary btn-sm"
						role="button">Edit Post</a> <a href="post/delete?id=${post.id}"
						class="btn btn-danger btn-sm" role="button">Delete Post</a>
				</div>
			</div>
		</div>
		<div class="container mt-2">
			<div class="row">
				<div class="col-md-12">
					<div class="">
						<h3>8 Comments</h3>
						<hr />
						<ul class="">
							<li class=""><img src="/images/default-profile-picture.png"
								class="" alt="">
								<div class="">
									<p class="">
										Dec 18, 2014 User says : <i class="pull-right"></i>
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Etiam a sapien odio, sit amet</p>
								</div></li>
							<li class=""><img src="/images/default-profile-picture.png"
								class="" alt="">
								<div class="">
									<p class="">
										Dec 18, 2014 User says : <i class="pull-right"></i>
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Etiam a sapien odio, sit amet</p>
								</div></li>
						</ul>
					</div>
					<form class="mb-3" action="post/create" method="post">
						<div class="form-group">
							<label for="content">Comment:</label>
							<textarea class="form-control" name="content" required>
				</textarea>
						</div>
						<button type="submit" class="btn btn-success mt-2">Post</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
