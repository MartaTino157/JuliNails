
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p>${info}</p>
<form action="createManItem">
    <div class="group-form">
        <label for="servManName">Название услуги</label>
        <input type="text" class="form-control" id="servManName" name="servManName" value="${servManName}" placeholder="Введите название процедуры"> 
    </div>
    <div class="group-form">
        <label for="servManPrice">Стоимость</label>
        <input type="text" class="form-control" id="servManPrice" name="servManPrice" value="${servManPrice}" placeholder="Введите стоимость процедуры"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
</form>
