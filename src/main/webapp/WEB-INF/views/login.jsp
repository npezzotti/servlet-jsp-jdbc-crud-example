<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="Login">
	<div class="container col-md-5 mt-5">
		<div class="card">
			<div class="card-body">
				<form action="login" method="post">
					<h2>Login</h2>
					<c:if test="${error != null}">
						<div class="alert alert-danger" role="alert">${error}</div>
					</c:if>
					<div class="form-group">
						<label for="email">Email</label>
						<input type="text"
							class="form-control"
							name="email"
							required />
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password"
							class="form-control"
							name="password"
							required />
					</div>
					<button type="submit" class="btn btn-success mt-2">Login</button>
					<p class="mt-2">Don't have an account? <a href="register">Register here.</a></p>
				</form>
			</div>
		</div>
	</div>
</t:base>
