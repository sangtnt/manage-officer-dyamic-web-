<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td></td>
				<td><h1>Login</h1></td>
			</tr>
			<tr>
				<th>Username: </th>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<th>Password: </th>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Login</button></td>
			</tr>
			<tr>
					<td></td>
					<td>${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>