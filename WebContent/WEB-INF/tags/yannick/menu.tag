<%@ tag description="Main navigation menu" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="menu" id="mainmenu">
	<ul>
		<li><a href="<c:url value="/index.htm" />">Root</a></li>
		<c:if test="${empty user}">
		<li><a href="<c:url value="/login.htm" />">Log in</a></li>
		</c:if>
		<c:if test="${user.admin}">
		<li><a href="<c:url value="/admin.htm" />">Admin</a></li>
		</c:if>
	</ul>
		<c:if test="${not empty user}">
			<form method="post" action="<c:url value="/index.htm"/>" id="logoutform">
				<input type="submit" value="Log out" name="logout" id="logoutbutton" />
			</form>
		</c:if>
</nav>