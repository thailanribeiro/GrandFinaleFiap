package br.com.fiap.DAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Pessoa;
import br.com.fiap.model.PessoaFisica;
import br.com.fiap.model.PessoaJuridica;

public class DAO {

    private Connection connection;

    public DAO() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM99989", "170893");
    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public List<Pessoa> getAll() throws SQLException {
        String sql = "SELECT * FROM pessoa";

        PreparedStatement statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        while (resultSet.next()) {
            Pessoa tbl_pessoa = new Pessoa();
            tbl_pessoa.setPessoa_id(resultSet.getBigDecimal("pessoa_id"));
            tbl_pessoa.setNome(resultSet.getString("nome"));
            tbl_pessoa.setCidade(resultSet.getString("cidade"));
            tbl_pessoa.setEndereco(resultSet.getString("endereco"));
            pessoas.add(tbl_pessoa);
        }

        System.out.println("Lista de pessoas obtida!");
        return pessoas;
    }
    
    public List<PessoaFisica> getAllPessoaFisica() throws SQLException {
        String sql = "Select * From pessoa Inner Join pessoa_fisica on pessoa.pessoa_id = pessoa_fisica.pessoa_id";

        PreparedStatement statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<PessoaFisica> pessoas = new ArrayList<>();
        while (resultSet.next()) {
        	PessoaFisica tbl_pessoa = new PessoaFisica();
            tbl_pessoa.setPessoa_id(resultSet.getBigDecimal("pessoa_id"));
            tbl_pessoa.setNome(resultSet.getString("nome"));
            tbl_pessoa.setCidade(resultSet.getString("cidade"));
            tbl_pessoa.setEndereco(resultSet.getString("endereco"));
            //resto de fisica
            pessoas.add(tbl_pessoa);
        }

        System.out.println("Lista de pessoas obtida!");
        return pessoas;
    }
    
    public List<PessoaJuridica> getAllPessoaJuridica() throws SQLException {
        String sql = "Select * From pessoa Inner Join pessoa_juridica on pessoa.pessoa_id = pessoa_juridica.pessoa_id";

        PreparedStatement statement = this.connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<PessoaJuridica> pessoas = new ArrayList<>();
        while (resultSet.next()) {
        	PessoaJuridica tbl_pessoa = new PessoaJuridica();
            tbl_pessoa.setPessoa_id(resultSet.getBigDecimal("pessoa_id"));
            tbl_pessoa.setNome(resultSet.getString("nome"));
            tbl_pessoa.setCidade(resultSet.getString("cidade"));
            tbl_pessoa.setEndereco(resultSet.getString("endereco"));
            //resto de juridica
            pessoas.add(tbl_pessoa);
        }

        System.out.println("Lista de pessoas obtida!");
        return pessoas;
    }

    public Pessoa insert(Pessoa tbl_pessoa) throws SQLException {
        String sql = "{call INSERT INTO pessoa (nome, cidade, endereco) VALUES (?, ?, ?) RETURNING pessoa_id INTO ?}";

        try (CallableStatement callableStatement = this.connection.prepareCall(sql)) {
            callableStatement.setString(1, tbl_pessoa.getNome());
            callableStatement.setString(2, tbl_pessoa.getCidade());
            callableStatement.setString(3, tbl_pessoa.getEndereco());

            callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);

            callableStatement.executeUpdate();

            BigDecimal id = callableStatement.getBigDecimal(4);
            tbl_pessoa.setPessoa_id(id);
        }

        System.out.println("Pessoa " + tbl_pessoa.getNome() + " incluída com sucesso!");
        System.out.println(tbl_pessoa);

        return tbl_pessoa;
    }

    public String insertTipoPessoa(PessoaFisica tbl_pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa_fisica (rg, cpf, pessoa_id) VALUES (?, ?, ?)";

        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, tbl_pessoa.getCpf());
        statement.setString(2, tbl_pessoa.getRg());
        statement.setBigDecimal(3, tbl_pessoa.getPessoa_id());

        System.out.println("Tipo de pessoa física incluída com sucesso!");

        statement.execute();
        return "Inserido com sucesso";
    }


    public String insertTipoPessoa(PessoaJuridica tbl_pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa_juridica (cnpj, razao_social, pessoa_id) VALUES (?, ?, ?)";

        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, tbl_pessoa.getCnpj());
        statement.setString(2, tbl_pessoa.getRazaoSocial());
        statement.setBigDecimal(3, tbl_pessoa.getPessoa_id());

        System.out.println("Tipo de pessoa jurídica incluída com sucesso!");

        statement.execute();
        return "Inserido com sucesso";
    }
    
    public Pessoa getPessoaById(int pessoa_id) throws SQLException {

        String sql = "SELECT * FROM PESSOA WHERE pessoa_id = ?";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, pessoa_id);

        ResultSet rs = statement.executeQuery();
        Pessoa pessoa = null;
        if (rs.next()) {
            pessoa = new Pessoa();
            pessoa.setPessoa_id(rs.getBigDecimal("pessoa_id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setCidade(rs.getString("cidade"));
            pessoa.setEndereco(rs.getString("endereco"));           
            rs.close();
        }
        return pessoa;
    }
}