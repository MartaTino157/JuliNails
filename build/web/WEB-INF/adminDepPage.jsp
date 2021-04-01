<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<a href="newDepItem">Добавить запись</a>
<h2>Депиляция</h2>
<table class="table table-hover">
    <thead>
        <tr>
            <th scope="col">Название процедуры</th>
            <th scope="col">Стоимость</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <c:forEach var="depService" items="${listDepilation}" varStatus="status">
        <tbody>
            <tr>
                <td>${depService.name}</td>
                <td>${depService.price}€</td>
                <td>Изменить</td>
                <td>Удалить</td>
            </tr>
        </tbody> 
    </c:forEach> 
</table>