<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Hotel Reservation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<div class="container my-2" align="center">

<h3>User List</h3>
<a th:href="@{/addnew}" class="btn btn-primary btn-sm mb-3" >Add User</a>
	<table style="width:80%" border="1"
		class = "table table-striped table-responsive-md">
	<thead>
<tr>
	<th>Name</th>
	<th>lastname</th>
	<th>action</th>

</tr>
</thead>
<tbody>
<tr th:each="user:${allUserList}">
		<td th:text="${user.name}"></td>
		<td th:text="${user.lastname}"></td>
		
		<td> <a th:href="@{/showFormForUpdate/{id}(id=${user.id})}"
				class="btn btn-primary">Update</a>
				<a th:href="@{/deleteUser/{id}(id=${user.id})}"
				class="btn btn-danger">Delete</a>
	</td>
</tr>
</tbody>
</table>
</div>
</body>
</html>
