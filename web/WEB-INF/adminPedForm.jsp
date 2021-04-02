
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<form action="createPedItem">
    <div class="group-form">
        <label for="servPedName">Название услуги</label>
        <input type="text" class="form-control" id="servPedName" name="servPedName" value="${servPedName}" placeholder="Введите название процедуры"> 
    </div>
    <div class="group-form">
        <label for="servPedPrice">Стоимость</label>
        <input type="text" class="form-control" id="servPedPrice" name="servPedPrice" value="${servPedPrice}" placeholder="Введите стоимость процедуры"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
</form>
