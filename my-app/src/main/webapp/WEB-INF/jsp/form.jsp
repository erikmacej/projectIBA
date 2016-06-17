<%-- 
    Document   : form
    Created on : Jun 17, 2016, 10:49:46 PM
    Author     : Erik Macej,433 744
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <form method="POST" action="http://localhost:8080/my-app/form">
            <label>Meno: <input type="text" name="input1" /></label><br>
            <label>Priezvisko: <input type="text" name="input2" /></label><br>
            <label>Dátum narodenia: <input type="text" name="input3" /></label><br>
            <label>Pohlavie: <input type="text" name="input4" /></label><br>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
