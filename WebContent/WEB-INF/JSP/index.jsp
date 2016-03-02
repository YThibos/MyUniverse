<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@ taglib prefix="tag" uri="http://yannick.be/tags" %>

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
	</section>

	<!-- IMPORT FOOTER -->
	<tag:footer/>

</body>

</html>