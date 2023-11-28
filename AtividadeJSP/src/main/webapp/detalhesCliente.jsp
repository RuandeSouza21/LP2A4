<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="fonts.css">
    <link rel="stylesheet" href="media.css">
    <title>Detalhes Cliente</title>
</head>
<header>
                <a href="AddCliente"><li>Cadastrar</li></a>
                <a href="ListarCliente"><li>Listar</li></a>
</header>
<body>
    <h1>Digite o Id do cliente</h1>
    <form method="post" action="DetalharCliente">
            <input type="number" name="id" placeholder="id" required="required">
            <input type="submit" value="Enviar">
    </form>

    <h1 name="cliente">Nome: ${cliente.nome}</h1>
    <p name="cliente">Data de Nascimento: ${cliente.dataNasc}</p>
    <p name="cliente">CPF: ${cliente.cpf}</p>
    <p name="cliente">Telefone: ${cliente.telefone}</p>

</body>
</html>