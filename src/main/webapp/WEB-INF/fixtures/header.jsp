<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a href="<c:url value='/posts'/>" class="navbar-brand">
			Jsp-Servlet-Hibernate Social Media App</a>
		<div class="collapse navbar-collapse">
			<c:if test="${user != null}">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/user/edit?id=${user.id}'/>">Edit Profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/logout'/>">Log out</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>
