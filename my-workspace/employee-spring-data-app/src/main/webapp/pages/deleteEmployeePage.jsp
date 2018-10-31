<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>Edit Employee</title>
	<link rel="stylesheet" href="styles/styles.css"/>
</head>
<body>
	<h2>Employee Form</h2>
	
	<form:form modelAttribute="employee" action="deleteEmployee" method="POST">
		<table>
			<tr>
				<td>
					<form:label path="employeeId">Employee Id</form:label>
				</td>
				<td>
					<form:input path="employeeId"/>
					<form:errors path="employeeId"></form:errors>
				</td>
			</tr>
		
			
			<tr>
				<td colspan="2" style="text-align:right">
				<button><span>Delete Employee</span></button>
				
				</td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>