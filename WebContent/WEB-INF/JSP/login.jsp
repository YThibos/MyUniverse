<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix="tag" uri="http://yannick.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
	<tag:head title="User login" />
</head>

<body>
	<tag:menu />
	
	<section class="content">
		<form action="" method="post" class="login form" id="userlogin">
			<label>User
			<span class="error">${errors.input}</span>
			<input name="username" type="text" autocomplete="off" class="inputbox" autofocus required />
			</label>
			<label>Password
			<span class="error">${errors.input}</span>
			<input name="password" type="password" autocomplete="off" class="inputbox" autofocus required />
			</label>
			<input type="submit" value="Log in" class="formbutton"/>
			<span class="error">${errors.user}</span>
		</form>
	</section>

	<tag:footer />

</body>

</html>