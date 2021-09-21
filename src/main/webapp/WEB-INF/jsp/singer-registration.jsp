<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Singer</title>
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

<div class="singer-registration">
    <form:form modelAttribute="singerRegistration">
    <h3>Singer information</h3>
        <label>Last name:</label><br/>
        <form:input path="user.lastName"/><br/>
        <form:errors path="user.lastName"  cssClass="errors-warning"/><br/>

        <label>First name:</label><br/>
        <form:input path="user.firstName"/><br/>
        <form:errors path="user.firstName"  cssClass="errors-warning"/><br/>

        <label>Username:</label><br/>
        <form:input path="user.username" id="username"/><br/>
        <form:errors path="user.username"  cssClass="errors-warning"/><br/>
         <c:if test="${not empty usernameExists}">
             <p  class="errors-warning">${usernameExists}</p>
         </c:if>

        <label>Email:</label><br/>
        <form:input path="user.email"/><br/>
        <form:errors path="user.email"  cssClass="errors-warning"/><br/>
        <c:if test="${not empty emailError}" >
            <p class="errors-warning">${emailError}</p>
        </c:if>

        <label>Phone number:</label><br/>
        <form:input path="user.phone"/><br/>
        <form:errors path="user.phone"  cssClass="errors-warning"/><br/>

        <label>Address:</label><br/>
        <form:input path="user.address"/><br/>
        <form:errors path="user.address"  cssClass="errors-warning"/><br/>

        <label>Password:</label><br/>
        <form:password path="user.password"/><br/>
        <form:errors path="user.password"  cssClass="errors-warning"/><br>

        <h3>Add a Schedule for the singer</h3>

        <label>Date:</label><br/>
        <form:input type="date" path="schedule.scheduleDate"/><br/>
        <form:errors path="schedule.scheduleDate"  cssClass="errors-warning"/><br/>

        <label>Time:</label><br/>
        <form:input type="text" path="schedule.time"/><br/>
        <form:errors path="schedule.time"  cssClass="errors-warning"/><br/>

        <label>Select the stage:</label><br/>
        <form:select path="schedule.stageId.stageId"><br/>
                <c:forEach items="${stageList}" var="stage">
                    <option value="${stage.stageId}">${stage.stageId} + ${stage.genre}</option>
                </c:forEach>
        </form:select>
        <form:errors path="schedule.stageId"  cssClass="errors-warning"/><br/>

        <input type="submit" value="Add Singer">
    </form:form>
</div>
</body>
</html>
