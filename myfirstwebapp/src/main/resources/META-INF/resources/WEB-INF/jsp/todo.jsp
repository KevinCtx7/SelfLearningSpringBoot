<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<%@ include file="common/header.jspf"%>

<title>Add Todos Page</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>

	<div class="container">
		<h1>Enter Todos Details</h1>
		<hr />

		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:errors path="description" cssClass="text-warning" />
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
			</fieldset>

			<fieldset class="mb-3">
				<form:errors path="targetDate" cssClass="text-warning" />
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input type="submit" class="btn btn-success" />
		</form:form>



	</div>



	<%@ include file="common/footer.jspf"%>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>



</body>
</html>