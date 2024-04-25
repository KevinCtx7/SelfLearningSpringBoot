<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<%@ include file="common/header.jspf"%>

<title>List Todos Page</title>
</head>
<body>
<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h1>Your Todos</h1>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>is Done?</th>
					<th></th>
					<th></th>
				</tr>

			</thead>

			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">Update</a></td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">DELETE </a></td>
					</tr>

				</c:forEach>
			</tbody>

		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>


	</div>

<%@ include file="common/footer.jspf"%>



</body>
</html>