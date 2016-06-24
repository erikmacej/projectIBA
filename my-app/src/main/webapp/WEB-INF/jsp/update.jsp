<%-- 
    Document   : update
    Created on : Jun 19, 2016, 4:42:54 AM
    Author     : Erik Macej,433 744
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <style>
            label.error {
                color: red;
            }
            input{
                color:black;
            }
        </style>
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
        
        <!--!jQuery-->
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        
        <!--datepicker-->
        <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
        
        <script type="text/javascript" src="resources/jquery.validate.min.js"></script>
        <script type="text/javascript" src="resources/jquery.ui.datepicker.validation.js"></script>
        <script type="text/javascript" src="resources/formularForm.js"></script>
                
    </head>
    <body>
        <form:form id="formularForm" method="POST" commandName="student" action="${pageContext.request.contextPath}/updatesubmit?id=${id}">
	    <p>
                <label for="name">Meno :</label>
		<form:input path="name" type="text"/>
            </p>
            <p>
		<label for="surname">Priezvisko :</label>
		<form:input path="surname" type="text"/>
            </p>
            <p>
                <label for="datepicker">Datum narozeni :</label>
                <form:input path="bornDate" id="datepicker" />
            </p>
            <p>
                <label for="sex">Pohlavie :</label>
                <form:select path="sex" type="text">
                    <form:option value="žena">žena</form:option>
                    <form:option value="muž">muž</form:option>
                </form:select>    
            </p>
            <p>
                <input type="submit" value="Potvrď"/>
            </p>
	</form:form>
            <form action="${pageContext.request.contextPath}/list">
                <input type="submit" value="Späť">
            </form>
    </body>
</html>
