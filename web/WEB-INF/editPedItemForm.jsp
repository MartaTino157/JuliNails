<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<h2>Редактирование записи </h2>
<form action="editPedicureItem">
    <input type="hidden" name="pedServiceId" value="${pedicure.id}">
    <div class="group-form">
        <label for="servPedName">Название услуги</label>
        <input type="text" class="form-control" id="servPedName" name="servPedName" value="${pedicure.name}"> 
    </div>
    <div class="group-form">
        <label for="servPedPrice">Стоимость</label>
        <input type="text" class="form-control" id="servPedPrice" name="servPedPrice" value="${pedicure.price}"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
    <a type="button" class="btn btn-secondary" href="pedicure">Отмена</a>
</form>