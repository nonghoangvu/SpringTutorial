<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Update Student</h1>
<form:form action="/app/student/update?id=${student.id}" method="post" modelAttribute="student">
    <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
    <div class="row mt-3">
        <div class="form-floating mb-3 col-6">
            <form:input path="fullName" type="text" class="form-control"/>
            <label>Full name</label>
        </div>
        <div class="form-floating mb-3 col-6">
            <form:input path="age" type="number" class="form-control"/>
            <label>Age</label>
        </div>
        <div class="form-floating mb-3">
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="gender" value="true"/>
                <label class="form-check-label">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="gender" value="false"/>
                <label class="form-check-label">Female</label>
            </div>
        </div>
        <button class="btn btn-outline-secondary">Submit</button>
    </div>
</form:form>
</body>
</html>
