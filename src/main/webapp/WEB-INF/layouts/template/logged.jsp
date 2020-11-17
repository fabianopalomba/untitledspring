<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title><tiles:insertAttribute name="titolo" /></title>
</head>
<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="<spring:url value="/home"/>">Renting Car</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/viewUser"/>">
                    <span class="oi oi-home" title="viewUser" aria-hidden="true"></span>
                    I tuoi dati
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/newRent" /> ">
                    <span class="oi oi-box" title="newRent" aria-hidden="true"></span>
                    Effettua un noleggio
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/logout" /> ">
                    <span class="oi oi-box" title="newRent" aria-hidden="true"></span>
                    Logout
                </a>
            </li>
        </ul>
    </div>
</nav>

<tiles:insertAttribute name="content" />
</body>
</html>