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
    <h1 class="h1 text-center text-secondary fs-2 mb-3">List Employee</h1>
    <div class="align-middle d-flex justify-content-center mb-5">
        <a href="/add" class="btn btn-outline-secondary"><i class="bi bi-person-plus-fill"></i> New employee</a>
    </div>
    <div>
        <div class="row mb-3">
            <div class="col-sm-12 col-md-6">
                <label>Display</label>
                <label>
                    <select class="form-control input-sm" onchange="window.location.href=this.value" name="limit">
                        <option ${limit == 5 ? "selected" : ""} value="/?page=0&limit=5">5</option>
                        <option ${limit == 10 ? "selected" : ""} value="/?page=0&limit=10">10</option>
                        <option ${limit == 25 ? "selected" : ""} value="/?page=0&limit=25">25</option>
                        <option ${limit == 50 ? "selected" : ""} value="/?page=0&limit=50">50</option>
                        <option ${limit == employees.totalElements ? "selected" : ""}
                                value="/?page=${employees.number}&limit=${employees.totalElements}">All
                        </option>
                    </select>
                </label>
                <label>results</label>
            </div>
            <div class="col-sm-12 col-md-6 text-end">
                <label>Search: </label>
                <label><input type="search" class="form-control form-control-sm"></label>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr class="text-center">
                <th scope="col">#</th>
                <th scope="col">FullName</th>
                <th scope="col">Gender</th>
                <th scope="col">Date Of Birth</th>
                <th scope="col">Country</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" var="e" items="${employees.content}">
                <form:form action="/update_name?id=${e.id}&page=${employees.number}&limit=${limit}" method="post"
                           modelAttribute="NewName">
                    <tr>
                        <th class="text-center" scope="row">${i.index + 1}</th>
                        <td class="d-flex justify-content-center">
                            <c:if test="${NewName.id == e.id}">
                                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <strong>Warning</strong> <form:errors path="*"></form:errors>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"
                                            aria-label="Close"></button>
                                </div>
                            </c:if>
                            <form:input type="text" value="${e.fullName}"
                                        class="form-control border border-0 bg-transparent focus-ring focus-ring-light w-50 ${NewName.id == e.id ? 'text-danger' : ''}"
                                        onblur="this.form.submit()" path="fullName"/>
                        </td>
                        <td class="text-center">${e.gender ? "Male" : "Female"}</td>
                        <td class="text-center">${e.dateOfBirth}</td>
                        <td class="text-center">${e.country.country}</td>
                        <td class="text-center">
                            <a href="/delete?id=${e.id}&page=${employees.number}&limit=${limit}" class="text-danger btn"><i class="bi bi-trash3-fill"></i></a>
                            <a href="/update?id=${e.id}" class="text-warning btn"><i class="bi bi-pencil-square"></i></a>
                        </td>
                    </tr>
                </form:form>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <div class="col-sm-9 align-middle justify-content-start">
                <span>Page count: ${employees.totalPages}</span>
            </div>
            <div class="col-sm-3 align-middle justify-content-end">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/?limit=${limit}&page=0">First</a></li>
                        <li ${employees.number <= 1 ? "hidden" : ""} class="page-item"><a class="page-link"
                                                                                          href="/?limit=${limit}&page=${employees.number - 1}">Previous</a>
                        </li>
                        <li class="page-item"><span class="page-link">${employees.number + 1}</span></li>
                        <li ${employees.number >= employees.totalPages - 1 ? "hidden" : ""} class="page-item"><a
                                class="page-link" href="/?limit=${limit}&page=${employees.number + 1}">Next</a></li>
                        <li class="page-item"><a class="page-link"
                                                 href="/?limit=${limit}&page=${employees.totalPages - 1}">Last</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
