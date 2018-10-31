<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="../pages/header.jsp" />

<main>
<h3>Employees in the Database:</h3>

<c:choose>
	<c:when test="${employees == null || empoyees.size() == 0 }">
		<h4>No Books Found</h4>
	</c:when>
	<c:otherwise>
		<table >
			<tr>
				<th>EmployeeId#</th>
				<th>Name</th>
				<th>Basic</th>
				<th>HRA</th>
				<th>Department</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${employees }" var="emp">
				<tr>
					<td>${emp.empId }</td>
					<td>${emp.name }</td>
					<td>${emp.basic }</td>
					<td>${emp.hra }</td>
					<td>${emp.dept }</td>
					<td>
					<!-- to send a variable with the url we send after '?' -->
						<a href="editEmployee?employeeId=${emp.empId }">Edit</a>
						<span>|</span>
						<a href="delEmployee?employeeId=${emp.empId }">Delete</a>
						
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
</c:choose> </main>

<jsp:include page="../pages/footer.jsp" />