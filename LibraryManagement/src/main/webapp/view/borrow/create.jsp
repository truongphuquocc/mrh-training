<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<!-- live -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<div class="p-3 mb-2 bg-light text-dark">
			<div>
				<h2>Borrow book</h2>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">

					<form action="borrow?action=insert" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Mã sinh viên</label> <select
									onchange="select()" class="selectpicker form-control"
									data-live-search="true" name="studentid" id="studentid"
									data-with="fit">
									<option value="0">Select Student ID</option>
									<c:forEach var="student" items="${listStudent}">
										<option data-name="${student.getName() }"
											value="${student.getStudentID()}">${student.getStudentID() }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Tên sinh viên</label> <input
									readonly="readonly" id="studentname" type="text"
									class="form-control" placeholder="Tên sinh viên">
							</div>
						</div>
						<div class="form-group">
							<label>Tên sách</label> <select class="selectpicker form-control"
								name="bookid" data-live-search="true" data-with="fit">
								<option value="0">Select Book Name</option>
								<c:forEach var="book" items="${listbook}">
									<option value="${book.getBookID()}">${book.getName()}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label>Số lượng</label> <input type="text" class="form-control"
								id="quantity" name="quantity" placeholder="Số lượng">
						</div>

						<button type="submit" class="btn btn-primary">
							<i class="fa-solid fa-floppy-disk"></i> Lưu Dữ Liệu
						</button>
						<a href="borrow" class="btn btn-warning"><i
							class="fa-solid fa-backward"></i> Quay Lại</a>
					</form>

				</div>
			</div>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
	<script>
		$('.datepicker').datepicker({
			inline : true
		});

		function select() {
			var d = document.getElementById("studentid");

			var displayValue = d.options[d.selectedIndex]
					.getAttribute("data-name");
			console.log(displayValue)
			document.getElementById("studentname").value = displayValue;
		}
	</script>
</body>
</html>