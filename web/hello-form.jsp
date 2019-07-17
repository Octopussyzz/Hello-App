<%--
  Created by IntelliJ IDEA.
  User: octopus
  Date: 15/07/19
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<html>
<head>
    <title>Hello Form</title>
</head>
<body>
<div class="container-fluid">
    <h1 class="text-center mb-5 mt-3">Fill the blank and let magic happen</h1>
    <div class="row justify-content-center">
            <form action="simple-hello" method="post" class="col-8">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input id="firstName" name="firstName" value="${param.firstName}" placeholder="Your little first name here">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your name with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input id="lastName" name="lastName" value="${param.lastName}" placeholder="Your last name here babe">
                    <small id="emailHelp2" class="form-text text-muted">Same for your last name my love.</small>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
</div>
</body>
</html>
