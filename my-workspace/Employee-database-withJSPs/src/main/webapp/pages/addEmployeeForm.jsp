<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="../pages/header.jsp" />


<main>
<h1>Enter Fresher Details</h1>
<form:form action="saveEmployee" modelAttribute="employee" method="POST">
	<div>

		<form:label path="empId">Employee Id:</form:label>
		<c:choose>
			<c:when test="${employee.empId==0 }">
				<form:input path="empId" type="number" />
			</c:when>
			<c:otherwise>
				<form:input path="empId" type="number" readonly="true" />
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<form:label path="name">Name:</form:label>
		<form:input path="name" type="text" />
	</div>
	<div>
		<form:label path="basic">Basic: </form:label>
		<form:input path="basic" type="number" />
	</div>

	<div>
		<form:label path="hra">HRA:</form:label>
		<form:input path="hra" type="number" />
	</div>
	<div>
		<form:label path="dept">Department:</form:label>
		<form:select path="dept">
			<form:option value="">--SELECT--</form:option>
			<form:options items="${posibDepts }" />
		</form:select>
	</div>
	<div>
		<form:button type="submit">Save</form:button>
	</div>
</form:form> </main>
<jsp:include page="../pages/footer.jsp" />
