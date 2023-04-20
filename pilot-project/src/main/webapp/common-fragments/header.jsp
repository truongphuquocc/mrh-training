<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="bg-dark">
	<div class="container">
		<nav
			class="navbar navbar-expand-sm bg-dark navbar-dark d-flex justify-content-between">
			<ul class="navbar-nav text-white">
				<li class="nav-item active"><a class="nav-link text-white"
					href="/brand">Brand</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="/product">Product</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<div class="dropdown d-flex align-items-center">
						<button type="button" class="btn user" data-toggle="dropdown">
							<span>hi:</span> ${pageContext.request.remoteUser}
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/logout">Sign out</a>
						</div>
					</div>
				</li>
			</ul>
		</nav>
	</div>
</div>