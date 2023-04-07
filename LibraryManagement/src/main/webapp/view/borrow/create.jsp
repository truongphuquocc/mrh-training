<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrow book</title>
<jsp:include page="../common/head.jsp" />
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="container">
			<div class="m-3">
				<h2>Borrow book</h2>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">
					<form action="borrow?action=insert" id="formborrow" name="borrow"
						method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Student ID</label> <select
									onchange="select()" class="selectpicker form-control"
									data-live-search="true" name="studentid" id="studentid"
									data-with="fit">
									<option value="">Select Student ID</option>
									<c:forEach var="student" items="${listStudent}">
										<option data-name="${student.getName() }"
											value="${student.getStudentID()}">${student.getStudentID() }</option>
									</c:forEach>
								</select> <label id="studentid-error" class="error" for="studentid"></label>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Student name</label> <input
									readonly="readonly" id="studentname" name="studentname" type="text"
									class="form-control" placeholder="Student name">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Book Name</label> <select onchange="selectBook()"
									class="selectpicker form-control" name="bookid" id="bookid"
									data-live-search="true" data-with="fit">
									<option value="">Select Book Name</option>
									<c:forEach var="book" items="${listbook}">
										<option data-book="${book.getQuantity() }"
											value="${book.getBookID()}">${book.getName()}</option>
									</c:forEach>
								</select> <label id="studentid-error" class="error" for="bookid"></label>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Total number of books</label> <input
									readonly="readonly" id="quantitybook" type="text"
									class="form-control" placeholder="Total number of books">
							</div>
						</div>
						<div class="form-group">
							<label>Quantity</label> <input type="text" class="form-control"
								id="quantity" name="quantity" placeholder="Quantity"> <label
								 class="error-be error-quantity"></label>
						</div>
						<button type="submit" class="btn btn-primary">
							<i class="fa-solid fa-floppy-disk"></i> Save
						</button>
						<a href="borrow" class="btn btn-warning"><i
							class="fa-solid fa-backward"></i> Cancel</a>
					</form>
				</div>
			</div>
		</div>
	</main>

	<%-- 	<script type="text/javascript"
		src="${jakarta.servlet.jsp.PageContext}assets/js/index.js"></script> --%>
</body>
<jsp:include page="../common/script.jsp" />
</html>