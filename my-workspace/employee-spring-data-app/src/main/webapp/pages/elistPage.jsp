<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Employees List</title>
		<link rel="stylesheet" href="styles/styles.css"/>
	</head>
	<body>
		<h3>Employee List</h3>
		
		<a href="addEmployee">Add Employee</a>
		<a href="editEmployee">Edit Employee</a>
		<a href="deleteEmployee">Delete Employee</a>
		
		<c:choose>
		<c:when test = "${employees eq null or employees.size() eq 0 }">
			<h3>No Records Found!</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Employee#</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Date Of Birth</th>
				</tr>
				<c:forEach items="${employees }" var="employee">
					<tr>
						<td>${employee.employeeId }</td>
						<td>${employee.firstName } ${employee.lastName }</td>
						<td>${employee.mobileNumber }</td>
						<td>${employee.emailId }</td>
						<td>${employee.dateOfBirth }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
		</c:choose>
	</body>
</html>