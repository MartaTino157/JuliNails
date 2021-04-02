
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<form action="createDepItem">
    <div class="group-form">
        <label for="servDepName">Название услуги</label>
        <input type="text" class="form-control" id="servDepName" name="servDepName" value="${servDepName}" placeholder="Введите название процедуры"> 
    </div>
    <div class="group-form">
        <label for="servDepPrice">Стоимость</label>
        <input type="text" class="form-control" id="servDepPrice" name="servDepPrice" value="${servDepPrice}" placeholder="Введите стоимость процедуры"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
</form>
