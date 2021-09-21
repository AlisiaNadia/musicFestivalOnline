<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Band</title>
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
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="festival-news">Festival news</a>
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

<div class="band-registration">

    <form:form modelAttribute="bandRegistration">
        <h3>Add band and band members</h3>

        Band name:<form:input path="name"/>
        <form:errors path="name" />

        <c:forEach items="${bandRegistration.users}" var="user" varStatus="i">
            <div class="member">

                <label>Last name: </label>
                <form:input path="users[${i.index}].lastName" value="${user.lastName}"/>
                <form:errors path="users[${i.index}].lastName" />

                <label>First name: </label>
                <form:input path="users[${i.index}].firstName" value="${user.firstName}"/>
                <form:errors path="users[${i.index}].firstName" />


                <label>Email:</label>
                <form:input path="users[${i.index}].email" value="${user.email}"/>
                <form:errors path="users[${i.index}].email" />


                <label>Phone:</label>
                <form:input path="users[${i.index}].phone" value="${user.phone}"/>
                <form:errors path="users[${i.index}].phone" />

                <label>Address: </label>
                <form:input path="users[${i.index}].address" value="${user.address}"/>
                <form:errors path="users[${i.index}].address" />

                <label>Username:</label>
                <form:input path="users[${i.index}].username" value="${user.username}"/>
                <form:errors path="users[${i.index}].username" />
                <c:if test="${not empty usernameErrors[i.index]}">
                    ${usernameErrors[i.index]}

                </c:if>

                <label>Password:</label>
                <form:password  path="users[${i.index}].password" value="${user.password}"/><br/>
                <form:errors path="users[${i.index}].password" />

            </div>
                </c:forEach>
        <input type="submit" name="addMember" value="Add Member">

        <h3>Add a Schedule for the band</h3>

        <label>Date:</label>
        <fmt:formatDate value="${schedule.scheduleDate}" var="dateString" pattern="dd/MM/yyyy" />
        <form:input type="date" path="schedule.scheduleDate"/>
        <form:errors path="schedule.scheduleDate" />

        <label>Time:</label>
        <form:input type="text" path="schedule.time"/>
        <form:errors path="schedule.time" />

        <label>Stage:</label>
        <form:select path="schedule.stageId.stageId">
            <c:forEach items="${bandStageList}" var="stage">
                <option value="${stage.stageId}">${stage.stageId}  + ${stage.genre}</option>
            </c:forEach>
        </form:select>
        <form:errors path="schedule.stageId.stageId" />

        <input type="submit" name="register" value="Add Registration">
    </form:form>
</div>
</body>
</html>
