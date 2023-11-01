<%@page import="com.emergentes.modelo.Categorias"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%
    List<Categorias> categoria = (List<Categorias>) request.getAttribute("categoria");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Categorias</h1>
        <p><a href="CategoriasController?action=add">Nuevo</a></p>
        <table border="1" cellspacing ="0">
            <tr>
                <th>Id</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${categoria}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.categoria}</td>
                    <td><a href="CategoriasController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="CategoriasController?action=delete&id=${item.id}">Eliminar</a></td>
                   
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
