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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/Css/base.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
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
					<form action="borrow?action=none" method="post">
						<div class="form-row">
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="From day" class="form-control" name="fromday"
										id="fecha1">
									<div class="input-group-append">
										<span class="input-group-text"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="To day" class="form-control" name="today"
										id="fecha1">
									<div class="input-group-append">
										<span class="input-group-text"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="input-group d-flex col-8">

								<input type="text" class="form-control" name="searchvalue"
									placeholder="Something clever..">
								<div class="d-block">
									<button class="btn btn-primary" type="button">
										<i class="fa-solid fa-magnifying-glass"></i> Search
									</button>
									<a class="btn btn-success" href="borrow?action=new">
										<i class="fa-solid fa-plus"></i> Borrow
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
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="${jakarta.servlet.jsp.PageContext}assets/js/index.js"></script>
		
	<script type="text/javascript">
		$(function() {
			$(".datepicker").datepicker({
				language : "es",
				autoclose : true,
				format : "dd/mm/yyyy",
			});
		});
	</script>
</body>
</html>
