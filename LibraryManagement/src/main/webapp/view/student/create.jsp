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
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="p-3 mb-2 bg-light text-dark">
			<div>
				<h2>Add Student</h2>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">

					<c:if test="${student != null}">
						<form action="student?action=update" method="post">
					</c:if>
					<c:if test="${student == null}">
						<form action="student?action=insert" method="post">
					</c:if>
					<c:if test="${student != null}">
						<input type="hidden" name="id" class="input-field"
							value="${student.getStudentID()}" />
					</c:if>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							id="name" name="name" placeholder="Name"
							value="<c:out value='${student.name}'/>" autofocus> <small
							id="emailHelp" class="form-text text-danger">Vui lòng
							nhập...</small>
					</div>

					<div class="form-group">
						<label>Age</label> <input type="text" class="form-control"
							value="<c:out value='${student.age}'/>" id="age" name="age"
							placeholder="Email"> <small id="Email"
							class="form-text text-danger">Vui lòng nhập...</small>
					</div>
					<div class="form-group">
						<label>Gender</label> <select name="gender" class="form-control">
							<c:choose>
								<c:when test="${student.gender == true }">
									<option value="1" selected>Nam</option>
									<option value="0" >Nữ</option>
								</c:when>
								<c:otherwise>
									<option value="0" selected>Nữ</option>
									<option value="1" >Nam</option>
								</c:otherwise>
							</c:choose>

						</select>
					</div>


					<button type="submit" id="submit" class="btn btn-primary">
						<i class="fa-solid fa-floppy-disk"></i> Lưu Dữ Liệu
					</button>
					<a href="student" class="btn btn-warning"><i
						class="fa-solid fa-backward"></i>Quay Lại</a>
					</form>

				</div>
			</div>
		</div>
	</main>
</body>
</html>