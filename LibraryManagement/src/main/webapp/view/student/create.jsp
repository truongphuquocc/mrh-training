<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${student != null}">
	<title>Update Student</title>
</c:if>
<c:if test="${student == null}">
	<title>Add Student</title>
</c:if>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../common/head.jsp" />
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="container text-dark">
			<div class="mb-2 p-3">
				<c:if test="${student != null}">
					<h2>Update Student</h2>
				</c:if>
				<c:if test="${student == null}">
					<h2>Add Student</h2>
				</c:if>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">
					<c:if test="${student != null}">
						<form action="student?action=update" name="student" method="post">
					</c:if>
					<c:if test="${student == null}">
						<form action="student?action=insert" name="student" method="post">
					</c:if>
					<c:if test="${student != null}">
						<input type="hidden" name="id" class="input-field"
							value="${student.getStudentID()}" />
					</c:if>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							id="name" name="name" placeholder="Name"
							value="<c:out value='${student.name}'/>" autofocus>
					</div>
					<div class="form-group">
						<label>Age</label> <input type="text" class="form-control"
							value="<c:out value='${student.age}'/>" id="age" name="age"
							placeholder="Age">
					</div>
					<div class="form-group">
						<label>Gender</label>
						<c:if test="${student != null}">
							<select name="gender" class="form-control">
								<option value="">Select gender</option>
								<c:choose>
									<c:when test="${student.gender == true }">
										<option value="1" selected>Male</option>
										<option value="0">Female</option>
									</c:when>
									<c:otherwise>
										<option value="0" selected>Female</option>
										<option value="1">Male</option>
									</c:otherwise>
								</c:choose>
							</select>
						</c:if>
						gender
						<c:if test="${student == null}">
							<select name="gender" class="form-control">
								<option value="" selected>Select gender</option>
								<option value="1">Male</option>
								<option value="0">Female</option>
							</select>
						</c:if>
					</div>
					<button type="submit" id="submit" class="btn btn-primary">
						<i class="fa-solid fa-floppy-disk"></i> Save
					</button>
					<a href="student" class="btn btn-warning"><i
						class="fa-solid fa-backward"></i> Cancel</a>
					</form>
				</div>
			</div>
		</div>
	</main>
	<script type="text/javascript"
		src="${jakarta.servlet.jsp.PageContext}assets/js/index.js"></script>
</body>
<jsp:include page="../common/script.jsp" />
</html>