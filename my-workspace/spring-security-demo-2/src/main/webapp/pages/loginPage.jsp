<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%><html>
<head>
<title>Home</title>
<base href="/" />
</head>
<body>
	<h1>LogIn</h1>
	<form action="login" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<c:if test="${param.err eq true}">
			<p>
				<strong>Incorrect Username or Password! Access Denied</strong>
			</p>
		</c:if>
		<label>User Name: <input type="text" name="unm" /></label>
		 <label>Password: <input type="password" name="pwd" /></label>
		<button>Sign In</button>
	</form>
</body>
</html>
