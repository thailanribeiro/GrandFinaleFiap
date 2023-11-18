<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro no Cadastro</title>
    <!-- Link para o Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <div class="alert alert-danger" role="alert">
        <h4 class="alert-heading">Erro no Cadastro!</h4>
        <p>Desculpe, houve um erro durante o cadastro do usuário. Verifique seus dados e tente novamente.</p>
        <hr>
        <p class="mb-0">Se o problema persistir, entre em contato com o suporte.</p>
    </div>
    <button type="button" class="btn btn-primary"
			onclick="voltar()">Voltar para o Inicio</button>

    <!-- Link para o Bootstrap JS e jQuery -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script>
	    function voltar() {
	    	window.location.href = '/Servlets';
	    }
    </script>
</body>
</html>
