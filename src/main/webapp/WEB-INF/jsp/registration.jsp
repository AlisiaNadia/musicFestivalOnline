<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Festival</title>
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
<body>

<h1>Registration</h1>
<form:form modelAttribute="registration">
    <table>
        <tr>
            <td>
                Last name:
            </td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName" />
            </td>
        </tr>
        <tr>
            <td>
                First name:
            </td>
            <td>
                <form:input path="firstName"/>
                <form:errors path="firstName" />
            </td>
        </tr>
        <tr>
            <td>
                Username:
            </td>
            <td>
                <form:input path="username" id="username"/>
                <form:errors path="username" />
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
                <form:input path="email"/>
                <form:errors path="email" />
            </td>
        </tr>
        <tr>
            <td>
                Phone number:
            </td>
            <td>
                <form:input path="phone"/>
                <form:errors path="phone" />
            </td>
        </tr>
        <tr>
            <td>
                Address:
            </td>
            <td>
                <form:input path="address"/>
                <form:errors path="address" />
            </td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <form:password path="password"/>
                <form:errors path="password" />

            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Registration">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
