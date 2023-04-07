<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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