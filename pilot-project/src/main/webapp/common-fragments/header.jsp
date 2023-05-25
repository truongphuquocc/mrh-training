<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<header class="bg-dark">
	<div class="menu-toggle">
		<i class="fa fa-bars"></i>
	</div>
	<a class="navbar-brand text-white logo" href="/brand">Pilot Project</a>
	<nav class="">

		<ul class="">
			<li class=""><a class="" href="/brand">Brand</a></li>
			<li class=""><a class="" href="/product">Product</a></li>
	
			<li >
				<div
					class="btn-group dropup d-flex justify-content-center h-100 align-items-center">
					<button type="button" class="btn user dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span>HI:</span> ${pageContext.request.remoteUser}
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/logout">Sign out</a>
					</div>
				</div>
			</li>
		</ul>
	</nav>

</header>