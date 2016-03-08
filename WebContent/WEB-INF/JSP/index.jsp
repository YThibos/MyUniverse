<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@ taglib prefix="tag" uri="http://yannick.be/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
	<tag:head title="Who is Yannick" />
</head>

<body>

	<!-- HEADER START -->
	<header>
	
		<!-- IMPORT NAV MENU -->
		<tag:menu />
		
	</header>
	<!-- HEADER END -->

	<!-- WELCOME SECTION START -->
	<section class="content">
	
		<h1>Welcome ${sessionScope.user.username}</h1>
		
		<p>Nothing to see here .. for now.</p>
	</section>

	<!-- IMPORT FOOTER -->
	<tag:footer/>

</body>

</html>