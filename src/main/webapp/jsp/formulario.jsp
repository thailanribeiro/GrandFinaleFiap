<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
    <!-- Link para o Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <h1>Escolha o tipo de pessoa:</h1>
    <form action="jsp/processarFormulario.jsp" method="post">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="tipoPessoa" value="fisica" id="pessoaFisica">
            <label class="form-check-label" for="pessoaFisica">Pessoa Física</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="tipoPessoa" value="juridica" id="pessoaJuridica">
            <label class="form-check-label" for="pessoaJuridica">Pessoa Jurídica</label>
        </div>
        <br>
        <input class="btn btn-primary" type="submit" value="Continuar">
    </form>

    <!-- Link para o Bootstrap JS e jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
