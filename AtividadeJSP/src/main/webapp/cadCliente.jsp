<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Cadastrar Cliente</title>
</head>

<body>
    <form method="post" action="AddCliente">
        <input type="text" name="nome" placeholder="Nome" required="required">
        <input type="date" name="data" placeholder="Data de Nascimento" required="required">
        <label>CPF: 000.000.000-00</label>
        <input type="text" data-js="cpf" id="cpf" name="cpf" required="required">
        <label>Telefone: (00) 00000-0000</label>
        <input type="text" data-js="phone" id="phone" name="telefone" required="required">
        <input type="submit" value="Enviar">
    </form>

    <script src="scripts.js"></script>
</body>
</html>