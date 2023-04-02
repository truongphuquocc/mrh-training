<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Borrow management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="bg-dark">
		<div class="container">
			<nav
				class="navbar navbar-expand-lg bg-dark navbar-dark d-flex justify-content-start">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa-solid fa-house"></i></a></li>
					<li class="nav-item active"><a class="nav-link" href="student">Students</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="book">Books</a></li>
					<li class="nav-item"><a class="nav-link" href="borrow">Brrows</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Search
							Borrows</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}assets/js/index.js"></script>
</body>
</html>