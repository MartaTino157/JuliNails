<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href="home">На главную страницу</a>
<h2>Маникюр</h2>
<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Название процедуры</th>
            <th scope="col">Стоимость</th>
        </tr>
    </thead>
    <c:forEach var="manService" items="${listManicure}" varStatus="status">
        <tbody>
            <tr>
                <td>${manService.name}</td>
                <td>${manService.price}€</td>
            </tr>
        </tbody> 
    </c:forEach> 
</table>
