<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Bands</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styles/mystyle.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="buy-ticket">Buy Ticket</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="singersList">See singers list</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="bandsList">See bands list</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="singer-registration">Add singer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="band-registration">Add band</a>
        </li>
        <li class="nav-item">
            <sec:authorize access="!isAuthenticated()">
                <a class="nav-link" href="login">LogIn</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="nav-link" href="logout">Logout</a>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="!isAuthenticated()">
                <a class="nav-link" href="registration">Register</a>
            </sec:authorize>
            </a>
        </li>
    </ul>
</nav>
<body>
<table class="users">
    <tr>
        <td>Band Name</td>
        <td>Members</td>
        <td>Scheduled time</td>
        <td>Scheduled date</td>
        <td>Stage</td>
        <td>Stage genre</td>
    </tr>
    <c:forEach items="${bandsList}" var="band">
        <tr>
            <td>${band.bandName}</td>
            <td>
                <c:forEach items="${band.members}" var="member">
                    ${member.singerId.userId.lastName} ${member.singerId.userId.firstName} <br>
                 </c:forEach>
            </td>
                <td>${band.members.get(0).singerId.scheduleId.time}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${band.members.get(0).singerId.scheduleId.scheduleDate}"/></td>
                <td>${band.members.get(0).singerId.scheduleId.stageId.stageId}</td>
                <td>${band.members.get(0).singerId.scheduleId.stageId.genre}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
