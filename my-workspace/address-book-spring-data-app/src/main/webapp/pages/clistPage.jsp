<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Contacts List</title>
		<link rel="stylesheet" href="styles/styles.css"/>
	</head>
	<body>
		<h3>Contact List</h3>
		
		<a href="addContact">Add Contact</a>
		
		<c:choose>
		<c:when test = "${contacts eq null or contacts.size() eq 0 }">
			<h3>No Records Found!</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Contact#</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Date Of Birth</th>
				</tr>
				<c:forEach items="${contacts }" var="contact">
					<tr>
						<td>${contact.contactId }</td>
						<td>${contact.firstName } ${contact.lastName }</td>
						<td>${contact.mobileNumber }</td>
						<td>${contact.emailId }</td>
						<td>${contact.dateOfBirth }</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
		</c:choose>
	</body>
</html>