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
			<h3>Post</h3>
			<div
				class="panel 
			panel-default
			border 
			rounded mb-2
			bg-gradient-light 
			text-dark">
				<div class="panel-heading">
					<img <c:url value="/images/default-profile-picture.png"/>
						class="img-thumbnail" />
					<c:out value="${post.id}" />
					<c:out value="${post.userId}" />
					posted at
					<c:out value="${post.createdAt}" />
					:
				</div>
				<div class="panel-body">
					<c:out value="${post.content}" />
				</div>
				<a href="post/edit?id=<c:out value="${post.id}" />">View Post</a>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../fixtures/scripts.jsp" />
</html>
