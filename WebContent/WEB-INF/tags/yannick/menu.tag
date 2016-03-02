<%@ tag description="Main navigation menu" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation" id="mainnav">
	<ul>
		<li><a href="<c:url value="/index.htm" />">Root</a></li>
		<li><a href="<c:url value="/login.htm" />">Log in</a></li>
		<li><a href="<c:url value="/dummy2.htm" />">Dummy2</a></li>
	</ul>
</nav>