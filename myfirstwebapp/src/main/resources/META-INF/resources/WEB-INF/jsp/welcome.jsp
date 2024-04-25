<html>
	<head>
	<%@ include file="common/header.jspf"%>
		<title>Welcome Page</title>
	</head>
	<body>
		<%@ include file="common/navigation.jspf"%>
		<div class="container">
		<h1>
		Welcome 
		</h1>
		<div>
		Your Name :${name}
		</div>
		<hr>
		<div><a href="list-todos">Manage Your Todos</a></div>
		</div>

	</body>
	<%@ include file="common/footer.jspf"%>
</html>