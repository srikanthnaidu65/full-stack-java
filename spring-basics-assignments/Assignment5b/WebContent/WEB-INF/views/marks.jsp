<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
body {
	background-color: #f5f5f5;
}

table {
	font-family: arial, sans-serif;
	width: 350px;
}

td {
	text-align: left;
	padding: 8px;
	font-size: 25px;
}
</style>
</head>
<body>
	<h2>Student Marks</h2>
	<form:form method="POST" action="/SpringMvcWithXmlConfiguration/marks">
		<table>
			<tr>
				<td><form:label path="Science">Science:</form:label></td>
				<td><form:input path="science" /></td>
			</tr>
			<tr>
				<td><form:label path="Maths">Maths:</form:label></td>
				<td><form:input path="maths" /></td>
			</tr>
			<tr>
				<td><form:label path="English">English:</form:label></td>
				<td><form:input path="english" /></td>
			</tr>
			<tr>
				<td><form:label path="Total">Total:</form:label></td>
				<td><form:input path="total" readonly="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="calculateTotal" />
				</td>
			</tr>
		</table>
	</form:form>
</body>

</html>