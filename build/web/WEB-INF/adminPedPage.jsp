<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<a href="newPedItem">Добавить запись</a>
<h2>Педикюр</h2>
<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Название процедуры</th>
            <th scope="col">Стоимость</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <c:forEach var="pedService" items="${listPedicure}" varStatus="status">
        <tbody>
            <tr>
                <td>${pedService.name}</td>
                <td>${pedService.price}€</td>
                <td><a href="editPedicureItemForm?pedServiceId=${pedService.id}">Изменить</a></td>
                <td><a href="deletePedItem?pedServiceId=${pedService.id}">Удалить</a></td>
            </tr>
        </tbody> 
    </c:forEach> 
</table>