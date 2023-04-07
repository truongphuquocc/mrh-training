<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Book management</title>
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
					<h2>Book management</h2>
				</div>
				<div>
					<a class="btn btn-success" href="book?action=new"> <i
						class="fa-solid fa-plus"></i> Add new book
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
								<th scope="col">TotalPage</th>
								<th scope="col">Quantity</th>
								<th scope="col">Type</th>
								<th scope="col" class="text-center">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${listbook}">
								<tr>
									<th scope="row" class="name-item"><c:out
											value="${book.getName()}" /></th>
									<td><c:out value="${book.getTotalPage()}" /></td>
									<td><c:out value="${book.getQuantity()}" /></td>
									<td><c:out value="${book.getType()}" /></td>
									<td class="text-center"><c:choose>
											<c:when test="${ book.getInUsed() != 0 }">
												<a
													href="book?action=edit&id=<c:out value='${book.bookID}' />"
													class="btn btn-warning disabled" aria-disabled="true">
													<i class="fa-solid fa-pen"></i>
												</a>
												<a
													href="book?action=delete&id=<c:out value='${book.bookID}' />"
													class="btn btn-danger disabled" aria-disabled="true"> <i
													class="fa-solid fa-trash-can"></i>
												</a>
											</c:when>
											<c:otherwise>
												<a
													href="book?action=edit&id=<c:out value='${book.bookID}' />"
													class="btn btn-warning"> <i class="fa-solid fa-pen"></i>
												</a>
												<a href="<c:out value='${book.bookID}' />"
													class="btn btn-danger openmodal" data-id="${book.bookID}">
													<i class="fa-solid fa-trash-can"></i>
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