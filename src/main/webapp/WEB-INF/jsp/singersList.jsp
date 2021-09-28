<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Singers</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/mystyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

    <sec:authorize access="hasAuthority('ROLES_ADMIN')">
        <ul class="navbar-nav" >
            <li class="nav-item">
                <a class="nav-link" href="singer-registration">Add singer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="band-registration">Add band</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="add-stage">Add stage</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="add-festival">Add Festival</a>
            </li>
        </ul>
    </sec:authorize>

    <sec:authorize access="hasAuthority('ROLES_USER')">
        <ul class="navbar-nav" >
            <li class="nav-item">
                <a class="nav-link" href="festival-news">Festival news</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="buy-ticket">Buy Ticket</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="your-tickets">Your tickets</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="singersList">See singers list</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="bandsList">See bands list</a>
            </li>
        </ul>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <ul class="navbar-nav ml-auto" >
            <li class="nav-item">
                <a class="nav-link" href="logout">Logout</a>
            </li>
        </ul>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <ul class="nav navbar-nav ml-auto" >
            <li class="nav-item">
                <a class="nav-link" href="login">LogIn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="registration">Register</a>
            </li>
        </ul>
    </sec:authorize>

</nav>
<body>

<table class="list-container">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Scheduled time</th>
        <th>Scheduled date</th>
        <th>Stage</th>
        <th>Stage genre</th>
    </tr>
<c:forEach items="${singersList}" var="singer">
    <tr>
        <td>${singer.userId.firstName}</td>
        <td>${singer.userId.lastName}</td>
        <td>${singer.userId.username}</td>
        <td>${singer.scheduleId.time}</td>
        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${singer.scheduleId.scheduleDate}"/></td>
        <td>${singer.scheduleId.stageId.stageId}</td>
        <td>${singer.scheduleId.stageId.genre}</td>
    </tr>
</c:forEach>
    </table>
</body>
</html>
