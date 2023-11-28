<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Cliente</title>
</head>

<header>
            <a href="index.jsp"><li>Home</li></a>
            <a href="AddCliente"><li>Cadastrar</li></a>
            <a href="DetalharCliente"><li>Detalhar</li></a>


</header>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Data de  Nascimento</th>
            <th scope="col">CPF</th>
            <th scope="col">Telefone</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientes}" var="cliente">
               <tr>
                <td>${cliente.id}</td>
                  <td>${cliente.nome}</td>
                  <td>${cliente.dataNasc}</td>
                  <td>${cliente.cpf}</td>
                  <td>${cliente.telefone}</td>
               </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>