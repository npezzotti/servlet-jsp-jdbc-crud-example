<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a href="posts" class="navbar-brand">
			Social Media Application </a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link"
					href="edit?id=${user.id}">Edit Profile</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Log
						out</a></li>
			</ul>
		</div>
	</div>
</nav>
