<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../common/head.jsp" />
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="p-3 mb-2 text-dark">
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
									<th scope="row" class="name-item"><c:out
											value="${student.getName()}" /></th>
									<td><c:out value="${student.getAge()}" /></td>
									<c:choose>
										<c:when test="${student.gender == true }">
											<td>Male</td>
										</c:when>
										<c:otherwise>
											<td>Female</td>
										</c:otherwise>
									</c:choose>
									<td class="text-center"><c:choose>
											<c:when test="${ student.getInUsed() != 0 }">
												<a
													href="student?action=edit&id=<c:out value='${student.studentID}' />"
													class="btn btn-warning"> <i class="fa-solid fa-pen"></i>
												</a>
												<a
													href="student?action=delete&id=<c:out value='${student.studentID}' />"
													class="btn btn-danger disabled" aria-disabled="true"> <i
													class="fa-solid fa-trash-can"></i>
												</a>
											</c:when>
											<c:otherwise>
												<a
													href="student?action=edit&id=<c:out value='${student.studentID}' />"
													class="btn btn-warning"> <i class="fa-solid fa-pen"></i>
												</a>
												<a data-id="${student.studentID}"
													href="student?action=delete&id=<c:out value='${student.studentID}' />"
													class="btn btn-danger openmodal"> <i
													class="fa-solid fa-trash-can"></i>
												</a>
											</c:otherwise>
										</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<!-- Modal delete -->
	<jsp:include page="../common/modaldelete.jsp" />
</body>
<jsp:include page="../common/script.jsp" />
</html>