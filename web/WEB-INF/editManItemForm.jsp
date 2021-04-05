<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<h2>Редактирование записи </h2>
<form action="editManicureItem">
    <input type="hidden" name="manServiceId" value="${manicure.id}">
    <div class="group-form">
        <label for="servManName">Название услуги</label>
        <input type="text" class="form-control" id="servManName" name="servManName" value="${manicure.name}"> 
    </div>
    <div class="group-form">
        <label for="servManPrice">Стоимость</label>
        <input type="text" class="form-control" id="servManPrice" name="servManPrice" value="${manicure.price}"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
    <a type="button" class="btn btn-secondary" href="manicure">Отмена</a>
</form>