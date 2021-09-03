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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
<form:form modelAttribute="singerRegistration">
    <h1>Add Singer</h1>
    <table>
        <tr>
            <td>
                Last name:
            </td>
            <td>
                <form:input path="user.lastName"/>
                <form:errors path="user.lastName" />
            </td>
        </tr>
        <tr>
            <td>
                First name:
            </td>
            <td>
                <form:input path="user.firstName"/>
                <form:errors path="user.firstName" />
            </td>
        </tr>
        <tr>
            <td>
                Username:
            </td>
            <td>
                <form:input path="user.username" id="username"/>
                <form:errors path="user.username" />
            </td>
            <td style="color: red">
                <c:if test="${not empty errors}">
                    ${errors}
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                Email:
            </td>
            <td>
                <form:input path="user.email"/>
                <form:errors path="user.email" />
            </td>
        </tr>
        <tr>
            <td>
                Phone number:
            </td>
            <td>
                <form:input path="user.phone"/>
                <form:errors path="user.phone" />
            </td>
        </tr>
        <tr>
            <td>
                Address:
            </td>
            <td>
                <form:input path="user.address"/>
                <form:errors path="user.address" />
            </td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <form:password path="user.password"/>
                <form:errors path="user.password" />
            </td>
        </tr>
        </tr>
    </table>

    <h1>Add a Schedule for the singer</h1>
    <table>
        <tr>
            <td>
                Date:
            </td>
            <td>
                <form:input type="date" path="schedule.scheduleDate"/>
                <form:errors path="schedule.scheduleDate" />
            </td>
        </tr>
        <tr>
            <td>
                Time:
            </td>
            <td>
                <form:input type="text" path="schedule.time"/>
                <form:errors path="schedule.time" />
            </td>
        </tr>
                <tr>
                    <td>Stage</td>
                    <td>
                        <form:select path="schedule.stageId.stageId">
                            <option value="top">Stage</option>
                            <c:forEach items="${stageList}" var="stage">
                                <option value="${stage.stageId}">${stage.stageId} + ${stage.genre}</option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="schedule.stageId" />
                    </td>
                </tr>
    </table>
    <input type="submit" value="Add Singer">
</form:form>

</body>
</html>
