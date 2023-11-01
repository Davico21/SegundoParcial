<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Categorias"%>
<%
    Categorias categoria = (Categorias) request.getAttribute("categoria");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo</h1>
        <form action="CategoriasController" method="post">
            <input type="hidden" name="id" value="${categoria.id}"/>
            <table>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value = "${categoria.categoria}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>  
    </body>
</html>
