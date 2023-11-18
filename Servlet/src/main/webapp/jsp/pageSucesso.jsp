<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sucesso no Cadastro</title>
    <!-- Link para o Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container mt-5">

    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Cadastro Concluído!</h4>
        <p>O usuário foi cadastrado com sucesso. Obrigado por se cadastrar.</p>
        <hr>
        <p class="mb-0">Você pode fazer login agora.</p>
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
