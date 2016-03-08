<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@ taglib prefix="tag" uri="http://yannick.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
	<tag:head title="Who is Yannick" />
</head>

<body>

	<!-- IMPORT NAV MENU -->
	<tag:menu />

	<!-- WELCOME SECTION START -->
	<section class="content">
		<h1>Welcome ${sessionScope.user.username}</h1>
		<c:if test="${empty sessionScope.user}">user empty</c:if>
		<c:if test="${loggedin == true}">User logged in</c:if>
		
	</section>

	<!-- IMPORT FOOTER -->
	<tag:footer/>

</body>

</html>