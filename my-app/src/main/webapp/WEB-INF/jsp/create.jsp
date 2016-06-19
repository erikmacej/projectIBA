<%-- 
    Document   : form
    Created on : Jun 17, 2016, 10:49:46 PM
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
            .error {
                color: #ff0000;
            }

            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body>
        <form:form method="POST" commandName="student" action="${pageContext.request.contextPath}/create">
	    <form:errors path="*" cssClass="errorblock" element="div" />
		<table>
		    <tr>
			<td>Meno :</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		    </tr>
		    <tr>
			<td>Priezvisko :</td>
			<td><form:input path="surname" /></td>
			<td><form:errors path="surname" cssClass="error" /></td>
		    </tr>
                    <tr>
			<td>Datum narozeni :</td>
			<td><form:input path="bornDate" /></td>
			<td><form:errors path="bornDate" cssClass="error" /></td>
		    </tr>
                    <tr>
			<td>Pohlavie :</td>
			<td><form:input path="sex" /></td>
			<td><form:errors path="sex" cssClass="error" /></td>
		    </tr>
		    <tr>
			<td colspan="3"><input type="submit" value="Potvrď"/></td>
		    </tr>
		</table>
	</form:form>
            <form action="${pageContext.request.contextPath}/list">
                <input type="submit" value="Späť">
            </form>
    </body>
</html>
