<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nong Hoang Vu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Validate Form</h1>
    <form:form method="post" modelAttribute="user">
        <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
        <div class="form-floating mb-3 mt-3">
            <form:input type="text" class="form-control" id="username" path="username"/>
            <label for="username">Username</label>
        </div>
        <div class="form-floating mb-3 mt-3">
            <form:input type="number" class="form-control" id="age" path="age"/>
            <label for="age">Age</label>
        </div>
        <div class="mb-3">
            <form:select class="form-select" path="relationship">
                <option value="" disabled selected>Relationship</option>
                <form:option value="Singer">Singer</form:option>
                <form:option value="In a relationship">In a relationship</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>
        <div class="form-check mb-3">
            <form:checkbox class="form-check-input" value="true" id="flexCheckDefault" path="verify"/>
            <label class="form-check-label" for="flexCheckDefault">
                Verify
            </label>
        </div>
        <button class="btn btn-success">Submit</button>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>
