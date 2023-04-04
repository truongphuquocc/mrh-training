<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Student management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/Css/base.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="container">
			<div class="m-3">
				<h2>Borrow management</h2>
			</div>
		</div>
		<div class="container ">
			<div class="box box-success">
				<div class="box-body">
					<form action="borrow?action=none" method="get">
						<div class="form-row">
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="From day" class="form-control cursor-pointer" readonly
										name="fromday" id="fecha1">
									<div class="input-group-append">
										<span class="input-group-text cursor-pointer"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="To day" class="form-control cursor-pointer" readonly
										name="today" id="fecha2">
									<div class="input-group-append">
										<span class="input-group-text cursor-pointer"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-4 d-flex col-8">
								<input type="text" class="form-control" name="searchvalue"
									placeholder="Something clever..">
								<div class="d-block">
									<button class="btn btn-primary" type="submit">
										<i class="fa-solid fa-magnifying-glass"></i> Search
									</button>
									<a class="btn btn-success" href="borrow?action=new"> <i
										class="fa-solid fa-plus"></i> Borrow
									</a>
								</div>

							</div>
						</div>
					</form>

					<table class="table table-striped text-center">
						<thead>
							<tr>
								<th scope="col">Book Id</th>
								<th scope="col">Book name</th>
								<th scope="col">Borrow date</th>
								<th scope="col">Student Id</th>
								<th scope="col">Student name</th>
								<th scope="col">Quantity</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="borrow" items="${listborrow}">
								<tr>
									<th><c:out value="${borrow.getBookID()}" /></th>
									<td><c:out value="${borrow.getBookName()}" /></td>
									<td><c:out value="${borrow.getBorrowDate()}" /></td>
									<td><c:out value="${borrow.getStudentID()}" /></td>
									<td><c:out value="${borrow.getStudentName()}" /></td>
									<td><c:out value="${borrow.getQuantity()}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.js"
		integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript"
		src="${jakarta.servlet.jsp.PageContext}assets/js/index.js"></script>
</body>
</html>
