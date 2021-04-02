
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <p>${info}</p>
        <h1>Вход для администратора</h1>
        <form action="login" method="POST">
            <input type="text" name="login" value="" placeholder="Логин"><br>
            <input type="text" name="password" value="" placeholder="Пароль"><br>
            <input type="submit" value="Войти"><br>
        </form>
    </body>
</html>
