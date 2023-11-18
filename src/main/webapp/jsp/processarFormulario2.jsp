<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Cadastro</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

	<h1>Formulário de Cadastro</h1>

	<%
	String tipoPessoa = request.getParameter("tipoPessoa");

	if ("fisica".equals(tipoPessoa)) {
	%>
	<h2>Cadastro Pessoa Física</h2>
	<form id="formularioPF">
		Nome: <input type="text" id="nome" name="nome"><br> 
		CPF:<input type="text" id="cpf" name="cpf"><br> 
		RG: <input type="text" id="rg" name="rg"><br> 
		CIDADE: <input type="text" id="cidade" name="cidade"><br> 
		ENDERECO: <input type="text" id="endereco" name="endereco"><br>
		<!-- Outros campos para pessoa física -->
		<input type="button" value="Cadastrar" onclick="enviarFormulario()">
		<input type="button" value="Voltar" onclick="voltar()">
	</form>
	<%
	} else if ("juridica".equals(tipoPessoa)) {
	%>
	<h2>Cadastro Pessoa Jurídica</h2>
	<form id="formularioPJ">
		NOME: <input type="text" id="nome" name="nome"><br>
		Razão Social: <input type="text" id="razaosocial" name="razaoSocial"><br>
		CNPJ: <input type="text" id="cnpj" name="cnpj"><br>
		CIDADE: <input type="text" id="cidade" name="cidade"><br> 
		ENDERECO: <input type="text" id="endereco" name="endereco"><br>
		<!-- Outros campos para pessoa jurídica -->
		<input type="button" value="Cadastrar" onclick="enviarFormularioPJ()">
		<input type="button" value="Voltar" onclick="voltar()">
	</form>
	<%
	}
	%>

	<script>
    function enviarFormulario() {
        // Obter valores do formulário
        const nome = document.getElementById("nome").value;
        const cpf = document.getElementById("cpf").value;
        const rg = document.getElementById("rg").value;
        const cidade = document.getElementById("cidade").value;
        const endereco = document.getElementById("endereco").value;

        // Criar objeto JavaScript
        const dados = {
            nome,cpf,rg,cidade,endereco
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
        console.log(nome)
        const cnpj = document.getElementById("cnpj").value;
        const razaosocial = document.getElementById("razaosocial").value;
        const cidade = document.getElementById("cidade").value;
        const endereco = document.getElementById("endereco").value;

        // Criar objeto JavaScript
        const dados = {
            nome,cnpj,razaosocial,cidade,endereco
            
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
    	window.location.href = '/Servlets/Pessoa';
    }
</script>

</body>
</html>
