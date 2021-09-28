<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add stage</title>
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

<div class="registration">
    <form:form modelAttribute="addStage">

        <h3>Add a new stage</h3>

        <label>Stage genre:</label>
        <form:input path="stage.genre"/><br/>
        <form:errors path="stage.genre" cssClass="errors-warning"/><br/>

        <label>Stage capacity:</label>
        <form:input path="stage.capacity"/><br/>
        <form:errors path="stage.capacity" cssClass="errors-warning"/><br/>

        <h3>Add a new ticket type</h3>
        <c:forEach items="${addStage.ticketInfo}" var="ticket" varStatus="i">
            <div class="member">

                <label>Ticket Amount: </label><br/>
                <form:input path="ticketInfo[${i.index}].amount" value="${ticket.amount}"/><br/>
                <form:errors path="ticketInfo[${i.index}].amount" cssClass="errors-warning"/><br/>

                <label>Ticket type: </label><br/>
                <form:input path="ticketInfo[${i.index}].type" value="${ticket.type}"/><br/>
                <form:errors path="ticketInfo[${i.index}].type" cssClass="errors-warning"/><br/>


                <label>Price:</label><br/>
                <form:input path="ticketInfo[${i.index}].price" value="${ticket.price}"/><br/>
                <form:errors path="ticketInfo[${i.index}].type"  cssClass="errors-warning"/><br/>

            </div>
        </c:forEach>

        <input type="submit" name="addNewTicket" value="Add new ticket type">
        <input type="submit" name="register" value="Add Registration">

    </form:form>
</div>
</body>
</html>
