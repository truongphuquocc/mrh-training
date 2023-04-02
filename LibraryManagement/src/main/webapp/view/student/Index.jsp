<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/Css/base.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- 	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Students</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Books</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Brrows</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Search
					Borrows</a></li>
		</ul>
	</nav> -->
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="p-3 mb-2 bg-light text-dark">
			<div class="container d-flex justify-content-between">
				<div>
					<h2>Student management</h2>
				</div>
				<div>
					<a class="btn btn-success" href="student?action=new"> <i
						class="fa-solid fa-plus"></i> Add new student
					</a>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Age</th>
								<th scope="col">Gender</th>
								<th scope="col" class="text-center">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="student" items="${listStudent}">
								<tr>
									<th scope="row"><c:out value="${student.getName()}" /></th>
									<td><c:out value="${student.getAge()}" /></td>
									<c:choose>
										<c:when test="${student.gender == true }">
											<td>Nam</td>
										</c:when>
										<c:otherwise>
											<td>Nữ</td>
										</c:otherwise>
									</c:choose>

									<td class="text-center"><a
										href="student?action=edit&id=<c:out value='${student.studentID}' />"
										class="btn btn-warning"><i class="fa-solid fa-pen"></i></a> <a
										href="student?action=delete&id=<c:out value='${student.studentID}' />"
										class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>