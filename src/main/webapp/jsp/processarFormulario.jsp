<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulário de Cadastro</title>
<!-- Link para o Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container mt-5">

	<h1>Formulário de Cadastro</h1>

	<%
	String tipoPessoa = request.getParameter("tipoPessoa");

	if ("fisica".equals(tipoPessoa)) {
	%>
	<h2>Cadastro Pessoa Física</h2>
	<form id="formularioPF">
		<div class="form-group">
			<label for="nome">Nome:</label> <input type="text"
				class="form-control" id="nome" name="nome">
		</div>
		<div class="form-group">
			<label for="cpf">CPF:</label> <input type="text" class="form-control"
				id="cpf" name="cpf">
		</div>
		<div class="form-group">
			<label for="rg">RG:</label> <input type="text" class="form-control"
				id="rg" name="rg">
		</div>
		<div class="form-group">
			<label for="cidade">Cidade:</label> <input type="text"
				class="form-control" id="cidade" name="cidade">
		</div>
		<div class="form-group">
			<label for="endereco">Endereço:</label> <input type="text"
				class="form-control" id="endereco" name="endereco">
		</div>
		<!-- Outros campos para pessoa física -->
		<button type="button" class="btn btn-primary"
			onclick="enviarFormulario()">Cadastrar</button>
		<button type="button" class="btn btn-primary"
			onclick="voltar()">Voltar</button>
	</form>
	<%
	} else if ("juridica".equals(tipoPessoa)) {
	%>
	<h2>Cadastro Pessoa Jurídica</h2>
	<form id="formularioPJ">
		<div class="form-group">
			<label for="nome">Nome:</label> <input type="text"
				class="form-control" id="nome" name="nome">
		</div>
		<div class="form-group">
			<label for="razaosocial">Razão Social:</label> <input type="text"
				class="form-control" id="razaosocial" name="razaoSocial">
		</div>
		<div class="form-group">
			<label for="cnpj">CNPJ:</label> <input type="text"
				class="form-control" id="cnpj" name="cnpj">
		</div>
		<div class="form-group">
			<label for="cidade">Cidade:</label> <input type="text"
				class="form-control" id="cidade" name="cidade">
		</div>
		<div class="form-group">
			<label for="endereco">Endereço:</label> <input type="text"
				class="form-control" id="endereco" name="endereco">
		</div>
		<!-- Outros campos para pessoa jurídica -->
		<button type="button" class="btn btn-primary"
			onclick="enviarFormularioPJ()">Cadastrar</button>
		<button type="button" class="btn btn-primary"
			onclick="voltar()">Voltar</button>
	</form>
	<%
	}
	%>

	<!-- Link para o Bootstrap JS e jQuery -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

	<script>
    function enviarFormulario() {
        // Obter valores do formulário
        const nome = document.getElementById("nome").value;
        const cpf = document.getElementById("cpf").value;
        const rg = document.getElementById("rg").value;
        const cidade = document.getElementById("cidade").value;
        const endereco = document.getElementById("endereco").value;
		const tipo = 'fisica';

        // Criar objeto JavaScript
        const dados = {
            nome,cpf,rg,cidade,endereco,tipo
        };

        // Enviar objeto usando Axios
        axios.post('http://localhost:8080/Servlets/Pessoa', dados)
            .then(function (response) {
                console.log(response.data);
                // Redirecionar ou realizar outras ações em caso de sucesso
                window.location.href = '/Servlets/jsp/pageSucesso.jsp';
            })
            .catch(function (error) {
                console.error(error);
                // Lidar com erros ou realizar outras ações em caso de falha
                window.location.href = '/Servlets/jsp/pageError.jsp';
            });
    }
    
    function enviarFormularioPJ() {
        // Obter valores do formulário
        const nome = document.getElementById("nome").value;
        const cnpj = document.getElementById("cnpj").value;
        const razaosocial = document.getElementById("razaosocial").value;
        const cidade = document.getElementById("cidade").value;
        const endereco = document.getElementById("endereco").value;
        const tipo = 'juridica';

        // Criar objeto JavaScript
        const dados = {
            nome,cnpj,razaosocial,cidade,endereco,tipo
        };

        // Enviar objeto usando Axios
        axios.post('http://localhost:8080/Servlets/Pessoa', dados)
            .then(function (response) {
                console.log(response.data);
                // Redirecionar ou realizar outras ações em caso de sucesso
                window.location.href = '/Servlets/jsp/pageSucesso.jsp';
            })
            .catch(function (error) {
                console.error(error);
                // Lidar com erros ou realizar outras ações em caso de falha
                window.location.href = '/Servlets/jsp/pageError.jsp';
            });
    }
    
    function voltar() {
    	window.location.href = '/Servlets';
    }
</script>

</body>
</html>
