<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

	<main>
		<div class="p-3 mb-2 bg-light text-dark">
			<div>
				<h2>Add book</h2>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">

					<c:if test="${book != null}">
						<form action="book?action=update" method="post">
					</c:if>
					<c:if test="${book == null}">
						<form action="book?action=insert" method="post">
					</c:if>
					<c:if test="${book != null}">
						<input type="hidden" name="id" class="input-field"
							value="${book.getBookID()}" />
					</c:if>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							id="name" name="name" placeholder="Name"
							value="<c:out value='${book.getName()}'/>" autofocus> <small
							id="emailHelp" class="form-text text-danger">Vui lòng
							nhập...</small>
					</div>

					<div class="form-group">
						<label>TotalPage</label> <input type="text" class="form-control"
							value="<c:out value='${book.getTotalPage()}'/>" id="totalpage"
							name="totalpage" placeholder="Total page"> <small
							id="Email" class="form-text text-danger">Vui lòng nhập...</small>
					</div>
					<div class="form-group">
						<label>Quantity</label> <input type="text" class="form-control"
							value="<c:out value='${book.getQuantity()}'/>" id="quantity"
							name="quantity" placeholder="Quantity"> <small id="Email"
							class="form-text text-danger">Vui lòng nhập...</small>
					</div>
					<div class="form-group">
						<label>Type</label> <input type="text" class="form-control"
							value="<c:out value='${book.getType()}'/>" id="type" name="type"
							placeholder="type"> <small id="Email"
							class="form-text text-danger">Vui lòng nhập...</small>
					</div>

					<button type="submit" id="submit" class="btn btn-primary">
						<i class="fa-solid fa-floppy-disk"></i> Lưu Dữ Liệu
					</button>
					<a href="./" class="btn btn-warning"><i
						class="fa-solid fa-backward"></i>Quay Lại</a>
					</form>

				</div>
			</div>
		</div>
	</main>
</body>
</html>