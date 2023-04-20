<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="logreg-forms">
	<form class="form-signin" id="formSigning" action="/loginAction" method="post">
		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
			Sign in</h1>
		<c:if test="${param.error != null}">
			<div class="error-message-invalid">Invalid username and password.
			</div>
		</c:if>
		<input type="text" id="username" name="username" class="form-control"
			placeholder="UserName"> 
		<input type="password" id="password"
			name="password" class="form-control" placeholder="Password">
		<button class="btn btn-success btn-block" id="submitLogin" type="submit">
			<i class="fas fa-sign-in-alt"></i> Sign in
		</button>
		<button class="btn btn-primary btn-block" type="button"
			id="btn-signup">
			<i class="fas fa-user-plus"></i> Sign up New Account
		</button>
	</form>
</div>
</html>