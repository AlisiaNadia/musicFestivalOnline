<%--
  Created by IntelliJ IDEA.
  User: asarb
  Date: 8/13/2021
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add Band</title>
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
            <a class="nav-link" href="ticket">Buy Ticket</a>
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
            <a class="nav-link" href="addBand">Add band</a>
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
<form:form modelAttribute="registration">
    <table>
        <tr>
            <td>
                Band name:
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        </tr>
        <h1>Add a Schedule for the band</h1>
        <table>
            <tr>
                <td>
                    Date:
                </td>
                <td>
                    <fmt:formatDate value="${schedule.scheduleDate}" var="dateString" pattern="dd/MM/yyyy" />
                    <form:input type="date" path="schedule.scheduleDate"/>
                </td>
            </tr>
            <tr>
                <td>
                    Time:
                </td>
                <td>

                    <form:input type="text" path="schedule.time"/>

                </td>
            </tr>
            <tr>
                <td>Stage</td>
                <td>
                    <form:select path="stage.stageId">
                        <option value="top">Stage</option>
                        <c:forEach items="${stageList}" var="stage">
                            <option value="${stage.stageId}">${stage.stageId}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
        </table>
        <tr>
            <td>
                <input type="submit" value="Add Registration">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
