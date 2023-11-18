package br.com.fiap.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.DAO.DAO;
import br.com.fiap.model.Pessoa;
import br.com.fiap.model.PessoaFisica;
import br.com.fiap.model.PessoaJuridica;
import br.com.fiap.model.PessoaTipo;
import br.com.fiap.model.ResultadoJson;

import com.google.gson.*;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/Pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PessoaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			DAO dao = new DAO();
			List<PessoaFisica> pessoasFisica = dao.getAllPessoaFisica();
			List<PessoaJuridica> pessoasJuridica = dao.getAllPessoaJuridica();
			dao.close();

			ResultadoJson resultadoJson = new ResultadoJson(pessoasFisica, pessoasJuridica);

			Gson gson = new Gson();
	        String json = gson.toJson(resultadoJson);

			response.setContentType("application/json");
	        response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(500);
			response.getWriter().append("{ msg: \"Erro interno do servidor\" }");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
	    BufferedReader bufferedReader = request.getReader();
	    String line;

	    while ((line = bufferedReader.readLine()) != null) {
	        sb.append(line);
	    }

	    String jsonInput = sb.toString();
	    
	    Gson gson = new Gson();
	    PessoaTipo pessoaTipo = gson.fromJson(jsonInput, PessoaTipo.class);

		String tipo = pessoaTipo.getTipo();
		String nome = pessoaTipo.getNome();
		String endereco = pessoaTipo.getEndereco();
		String cidade = pessoaTipo.getCidade();
		String cpf = pessoaTipo.getCpf();
		String rg = pessoaTipo.getRg();
		String cnpj = pessoaTipo.getCnpj();
		String razaosocial = pessoaTipo.getRazaosocial();
		Pessoa pessoa = new Pessoa();

		try {
			DAO dao = new DAO();

			if (nome == null) {
				response.setStatus(400);
				response.getWriter().append("{ msg: \"Por favor informe o nome\" }");
			} else if (endereco == null) {
				response.setStatus(400);
				response.getWriter().append("{ msg: \"Por favor informe o endereço\" }");
			} else if (cidade == null) {
				response.setStatus(400);
				response.getWriter().append("{ msg: \"Por favor informe a cidade\" }");
			}  else if (tipo == null) {
				response.setStatus(400);
				response.getWriter().append("{ msg: \"Por favor selecione um tipo de pessoa\" }");
			} else {
				pessoa.setNome(nome);
				pessoa.setEndereco(endereco);
				pessoa.setCidade(cidade);
				
				if (tipo.toLowerCase().equals("fisica")) {
					if (!validarCpf(cpf)) {
						response.setStatus(400);
						response.getWriter().append("{ msg: \"Por favor informe um cpf valido\" }");
					} else if (!validarRg(rg)) { // validação para o RG
						response.setStatus(400);
						response.getWriter().append("{ msg: \"Por favor informe um RG válido\" }");
					} else {
						PessoaFisica pf = new PessoaFisica();
						pf.setCpf(cpf);
						pf.setRg(rg);

						try {
							Pessoa pessoaInserida = dao.insert(pessoa);

							// Atualizar na pessoa o id de pessoa física
							pf.setPessoa_id(pessoaInserida.getPessoa_id());
							String retorno = dao.insertTipoPessoa(pf);
							dao.close();
							response.getWriter().append("{ msg: \"" + retorno + "\" }");
						} catch (SQLException e) {
							dao.close();
							response.sendError(500);
							response.getWriter().append("{ msg: \"Erro interno do servidor\" }");
							throw new RuntimeException(e);
						}
					}
				} else if (tipo.toLowerCase().equals("juridica")) {
					if (!validarCnpj(cnpj)) {
						response.setStatus(400);
						response.getWriter().append("{ msg: \"Por favor informe o cnpj\" }");
					} else if (razaosocial == null) {
						response.setStatus(400);
						response.getWriter().append("{ msg: \"Por favor informe a razão social\" }");
					} else {
						// regras de inserir pessoa juridica aqui
						PessoaJuridica pj = new PessoaJuridica();
						pj.setCnpj(cnpj);
						pj.setRazaoSocial(razaosocial);

						try {
							Pessoa pessoaInserida = dao.insert(pessoa);

							pj.setPessoa_id(pessoaInserida.getPessoa_id());
							String retorno = dao.insertTipoPessoa(pj);
							dao.close();
							response.getWriter().append("{ msg: \"" + retorno + "\" }");
						} catch (SQLException e) {
							dao.close();
							response.sendError(500);
							response.getWriter().append("{ msg: \"Erro interno do servidor\" }");
							throw new RuntimeException(e);
						}
					}
				} else {
					response.getWriter().append("{ msg: \"Pessoa deve ser fisica ou juridica\" }");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(500);
			response.getWriter().append("{ msg: \"Erro interno do servidor\" }");
		}
	}

	private Boolean validarCpf(String cpf) {
		cpf = cpf.replaceAll("[\\D]", "");
		System.out.println((cpf != null && cpf.length() == 11));
		return (cpf != null && cpf.length() == 11);
	}

	private Boolean validarRg(String rg) {
		rg = rg.replaceAll("[\\D]", "");
		// Verifica se o RG possui um formato específico de 9 digitos
		return rg.matches("\\d{9}");
	}

	private Boolean validarCnpj(String cnpj) {
		cnpj = cnpj.replaceAll("[\\D]", "");
		// Verifica se o CNPJ possui um formato específico de 14 digitos
		return (cnpj != null && cnpj.length() == 14);
	}
}
