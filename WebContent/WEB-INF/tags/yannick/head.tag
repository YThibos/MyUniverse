<%@ tag description="Standard head metadata and links for every page" pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="title" type="java.lang.String" required="true" %>

<title>${title}</title>

<meta http-equiv="content-type" content="text/html" charset="UTF-8" >
<meta name="author" content="Yannick Thibos">
<meta name="keywords" content="digital, resume, cv, curriculum, vitae, ">
<meta name="description" content="Online digital resume of Yannick Thibos, Java Enterprise Developer">

<meta name='viewport' content='width=device-width,initial-scale=1'>

<link rel="shortcut icon" href="<c:url value="/images/favicon.ico" />" type="image/x-icon" />

<link rel="stylesheet" href="<c:url value="/styles/normalize.css"/>" />
<link rel="stylesheet" href="<c:url value="/styles/default.css"/>" />
