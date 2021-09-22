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

        Band name:<form:input path="name"/><br/>
        <form:errors path="name" cssClass="errors-warning"/><br/>

        <c:forEach items="${bandRegistration.users}" var="user" varStatus="i">
            <div class="member">

                <label>Last name: </label><br/>
                <form:input path="users[${i.index}].lastName" value="${user.lastName}"/><br/>
                <form:errors path="users[${i.index}].lastName" cssClass="errors-warning"/><br/>

                <label>First name: </label><br/>
                <form:input path="users[${i.index}].firstName" value="${user.firstName}"/><br/>
                <form:errors path="users[${i.index}].firstName" cssClass="errors-warning"/><br/>


                <label>Email:</label><br/>
                <form:input path="users[${i.index}].email" value="${user.email}"/><br/>
                <form:errors path="users[${i.index}].email"  cssClass="errors-warning"/><br/>
                <c:if test="${not empty errorsBandMembers[i.index]}">
                    <p class="errors-warning">${errorsBandMembers[i.index]}</p>
                </c:if>

                <label>Phone:</label><br/>
                <form:input path="users[${i.index}].phone" value="${user.phone}"/><br/>
                <form:errors path="users[${i.index}].phone"  cssClass="errors-warning"/><br/>

                <label>Address: </label><br/>
                <form:input path="users[${i.index}].address" value="${user.address}"/><br/>
                <form:errors path="users[${i.index}].address"  cssClass="errors-warning"/><br/>

                <label>Username:</label><br/>
                <form:input path="users[${i.index}].username" value="${user.username}"/><br/>
                <form:errors path="users[${i.index}].username"  cssClass="errors-warning"/><br/>
                <c:if test="${not empty usernameErrors[i.index]}">
                    <p  class="errors-warning">${usernameErrors[i.index]}</p>
                </c:if>

                <label>Password:</label><br/>
                <form:password  path="users[${i.index}].password" value="${user.password}"/><br/>
                <form:errors path="users[${i.index}].password"  cssClass="errors-warning"/><br/>

            </div>
                </c:forEach>
        <input type="submit" name="addMember" value="Add Member">

        <h3>Add a Schedule for the band</h3>

        <label>Date:</label><br/>
        <fmt:formatDate value="${schedule.scheduleDate}" var="dateString" pattern="dd/MM/yyyy" />
        <form:input type="date" path="schedule.scheduleDate"/><br/>
        <form:errors path="schedule.scheduleDate"  cssClass="errors-warning"/><br/>

        <label>Time:</label><br/>
        <form:input type="text" path="schedule.time"/><br/>
        <form:errors path="schedule.time"  cssClass="errors-warning"/><br/>

        <label>Stage:</label><br/>
        <form:select path="schedule.stageId.stageId"><br/>
            <c:forEach items="${bandStageList}" var="stage">
                <option value="${stage.stageId}">${stage.stageId}  + ${stage.genre}</option>
            </c:forEach>
        </form:select>
        <form:errors path="schedule.stageId.stageId"  cssClass="errors-warning"/><br/>

        <input type="submit" name="register" value="Add Registration">
    </form:form>
</div>
</body>
</html>
