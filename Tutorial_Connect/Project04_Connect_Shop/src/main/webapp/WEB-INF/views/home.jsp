<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-secondary text-uppercase m-3">Shop Nong Hoang Vu</h1>
<div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="p" items="${products}">
        <div class="col">
            <div class="card h-100">
                <div class="card-body text-center w-100">
                    <img src="/getImage/${p.image.url}" class="card-img-top w-50" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">${p.productName}</h5>
                    <p class="card-text">${p.price} VND</p>
                </div>
                <div class="d-grid gap-2 col-6 mx-auto mb-3">
                    <a href="#" class="btn btn-warning text-white"><i class="bi bi-bag-fill"></i> Buy now</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>