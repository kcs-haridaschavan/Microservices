<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Hotel Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Hotel Management System</h1>
		<hr>
		<h2>Save User</h2>

		<form action="#" th:action="@{/save}" th:object="${user}"
			method="POST">
			<input type="text" th:field="*{name}" placeholder="User Name"
				class="form-control mb-4 col-4"> <input type="text"
				th:field="*{lastname}" placeholder="User LastName"
				class="form-control mb-4 col-4">

			<button type="submit" class="btn btn-info col-2">Save User</button>
		</form>

		<hr>

		<a th:href="@{/}"> Back to User List</a>
	</div>
</body>
</html>
