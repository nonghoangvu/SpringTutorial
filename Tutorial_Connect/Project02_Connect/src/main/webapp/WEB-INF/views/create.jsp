<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nong Hoang Vu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container-sm p-3">
    <h1 class="h1 text-center text-secondary fs-2 mb-3">Add New Employee</h1>
    <form:form action="/add" modelAttribute="employee" method="post">
        <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
        <div class="form-floating mb-3">
            <form:input path="fullName" type="text" class="form-control" id="floatingInput"/>
            <label for="floatingInput">Your name</label>
        </div>
        <div class="form-floating mb-3">
            <form:input path="dateOfBirth" type="date" class="form-control" id="floatingInput"/>
            <label for="floatingInput">Date of birth</label>
        </div>
        <div class="form-floating mb-3">
            <div class="form-check form-check-inline">Gender: </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="inlineRadioOptions" id="male"
                                  value="true"/>
                <label class="form-check-label" for="male">Male</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="gender" class="form-check-input" name="inlineRadioOptions" id="female"
                                  value="false"/>
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>
        <div class="form-floating mb-3">
            <form:select path="country" class="form-select" aria-label="Default select example">
                <option selected disabled>Country</option>
                <form:options items="${ListCountry}" itemValue="id" itemLabel="country"/>
            </form:select>
        </div>
        <div class="align-middle d-flex justify-content-center mb-5">
            <a href="/" class="btn btn-outline-danger"><i class="bi bi-house-fill"></i> Back</a>
            <button class="btn btn-outline-secondary"><i class="bi bi-person-fill-check text-primary"></i> Save</button>
        </div>
    </form:form>

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
