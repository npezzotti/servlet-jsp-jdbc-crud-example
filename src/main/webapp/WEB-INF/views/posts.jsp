<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="Posts">
	<div class="container mt-2">
		<div class="container mt-2">
			<form class="mb-3" action="post" method="post">
				<div class="form-group">
					<label for="content">Share something:</label>
					<textarea class="form-control"
						name="content"
						required>
					</textarea>
				</div>
				<button type="submit" class="btn btn-success mt-2">Post</button>
			</form>
			<h3>Latest Posts</h3>
			<c:forEach var="post" items="${posts}">
				<div class="panel 
				panel-default
				border 
				rounded mb-2
				bg-gradient-light 
				text-dark">
        			<div class="panel-heading">
        				<img <c:url value="/images/default-profile-picture.png"/> 
        				class="img-thumbnail"
        				/>
						<c:out value="${post.id}" />
						<c:out value="${post.userId}" /> posted at
						<c:out value="${post.createdAt}" />:
					</div>
					<div class="panel-body">
						<c:out value="${post.content}" />
					</div>
				<a href="comment">Comment</a>
				<a href="post?id=<c:out value="${post.id}" />">View Post</a>
				</div>
			</c:forEach>
		</div>
	</div>
</t:base>
