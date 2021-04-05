<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<a href="newManItem">Добавить запись</a>

<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Название процедуры</th>
            <th scope="col">Стоимость</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <c:forEach var="manService" items="${listManicure}" varStatus="status">
        <tbody>
            <tr>
                <td>${manService.name}</td>
                <td>${manService.price}€</td>
                <td><a href="editManicureItemForm?manServiceId=${manService.id}">Изменить</a></td>
                <td><a href="deleteManItem?manServiceId=${manService.id}">Удалить</a></td>
            </tr>
        </tbody> 
    </c:forEach> 
</table>