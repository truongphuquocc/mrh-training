<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Borrow management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../common/head.jsp" />
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
					<form action="borrow?action=search" id="formborrowsearch"
						method="post">
						<div class="form-row">
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="From day"
										class="form-control cursor-pointer" readonly name="fromday"
										id="fecha1">
									<div class="input-group-append">
										<span class="input-group-text cursor-pointer"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="form-group col-2">
								<div class="datepicker date input-group">
									<input type="text" placeholder="To day"
										class="form-control cursor-pointer" readonly name="today"
										id="fecha2">
									<div class="input-group-append">
										<span class="input-group-text cursor-pointer"><i
											class="fa fa-calendar"></i></span>
									</div>
								</div>
							</div>
							<div class="input-group mb-4 d-flex col-8">
								<input type="text" class="form-control" name="searchvalue"
									value="${sessionScope['studentname'] }"
									placeholder="Search here...">
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
					<div id="searchborrow">
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
		</div>
	</main>
</body>
<jsp:include page="../common/script.jsp" />
</html>
