<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base title="Posts">
	<div class="container mt-2">
		<h3 class="text-center">Posts</h3>
		<hr>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Content</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${posts}">
					<tr>
						<td><c:out value="${post.title}" /></td>
						<td><c:out value="${post.content}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</t:base>