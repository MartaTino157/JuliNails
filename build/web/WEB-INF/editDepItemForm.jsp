<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>${info}</p>
<h2>Редактирование записи </h2>
<form action="editDepilationItem">
    <input type="hidden" name="depServiceId" value="${depilation.id}">
    <div class="group-form">
        <label for="servDepName">Название услуги</label>
        <input type="text" class="form-control" id="servDepName" name="servDepName" value="${depilation.name}"> 
    </div>
    <div class="group-form">
        <label for="servDepPrice">Стоимость</label>
        <input type="text" class="form-control" id="servDepPrice" name="servDepPrice" value="${depilation.price}"> 
    </div>
    <button type="submit" name="submit" class="btn btn-primary">Сохранить</button>
    <a type="button" class="btn btn-secondary" href="depilation">Отмена</a>
</form>