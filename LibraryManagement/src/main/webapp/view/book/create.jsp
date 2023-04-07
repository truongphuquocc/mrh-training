<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${book != null}">
	<title>Update Book</title>
</c:if>
<c:if test="${book == null}">
	<title>Add Book</title>
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
				<c:if test="${book != null}">
					<h2>Update book</h2>
				</c:if>
				<c:if test="${book == null}">
					<h2>Add book</h2>
				</c:if>
			</div>
		</div>
		<div class="container">
			<div class="box box-success">
				<div class="box-body">
					<c:if test="${book != null}">
						<form action="book?action=update" name="book" method="post">
					</c:if>
					<c:if test="${book == null}">
						<form action="book?action=insert" name="book" method="post">
					</c:if>
					<c:if test="${book != null}">
						<input type="hidden" name="id" class="input-field"
							value="${book.getBookID()}" />
					</c:if>
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							id="name" name="name" placeholder="Name"
							value="<c:out value='${book.getName()}'/>" autofocus> <label
							class="error-be error-name"></label>
					</div>
					<div class="form-group">
						<label>TotalPage</label> <input type="text" class="form-control"
							value="<c:out value='${book.getTotalPage()}'/>" id="totalpage"
							name="totalpage" placeholder="Total page">
					</div>
					<div class="form-group">
						<label>Quantity</label> <input type="text" class="form-control"
							value="<c:out value='${book.getQuantity()}'/>" id="quantity"
							name="quantity" placeholder="Quantity">
					</div>
					<div class="form-group">
						<label>Type</label> <input type="text" class="form-control"
							value="<c:out value='${book.getType()}'/>" id="type" name="type"
							placeholder="type">
					</div>
					<button type="submit" id="submit" class="btn btn-primary">
						<i class="fa-solid fa-floppy-disk"></i>Save
					</button>
					<a href="book" class="btn btn-warning"><i
						class="fa-solid fa-backward"></i>Cancel</a>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
<jsp:include page="../common/script.jsp" />
</html>