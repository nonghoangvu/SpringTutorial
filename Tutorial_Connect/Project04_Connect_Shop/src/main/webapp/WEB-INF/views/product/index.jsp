<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-secondary text-uppercase m-3">Product management</h1>
<div class="text-center m-3 h5">
    <a href="/product/add">New Product</a>
</div>
<table class="table table-hover">
    <thead>
    <tr class="text-center table-secondary">
        <th scope="col">No</th>
        <th scope="col">Image</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Create Date</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody class="text center">
    <c:forEach items="${products}" var="p" varStatus="i">
        <tr>
            <th class="align-middle text-center" scope="row">${i.index + 1}</th>
            <td class="align-middle text-secondary text-center">
                <img src="/getImage/${p.image.url}" alt="Not found!" width="100px">
            </td>
            <td class="align-middle text-secondary text-center">${p.productName}</td>
            <td class="align-middle text-secondary text-center">${p.price}</td>
            <td class="align-middle text-secondary text-center">${p.description}</td>
            <td class="align-middle text-secondary text-center">${p.createDate}</td>
            <td class="align-middle text-secondary text-center">
                <a href="/product/delete?id=${p.id}" class="btn"><i class="bi bi-trash3-fill"></i></a>
                <a href="/product/update?id=${p.id}" class="btn"><i class="bi bi-pencil-square"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>