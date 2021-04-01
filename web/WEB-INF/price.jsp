<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    
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

    <h2>Педикюр</h2>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Название процедуры</th>
                <th scope="col">Стоимость</th>
            </tr>
        </thead>
        <c:forEach var="pedService" items="${listPedicure}" varStatus="status">
            <tbody>
                <tr>
                    <td>${pedService.name}</td>
                    <td>${pedService.price}€</td>
                </tr>
            </tbody> 
        </c:forEach> 
    </table>

    <h2>Депиляция</h2>
    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Название процедуры</th>
                <th scope="col">Стоимость</th>
            </tr>
        </thead>
        <c:forEach var="depService" items="${listDepilation}" varStatus="status">
            <tbody>
                <tr>
                    <td>${depService.name}</td>
                    <td>${depService.price}€</td>
                </tr>
            </tbody> 
        </c:forEach> 
    </table>
</div>