package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Pessoa {
    private BigDecimal pessoa_id;
    private String nome;
    private String cidade;
    private String endereco;    

    public Pessoa() {

    }

    public Pessoa(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public BigDecimal getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(BigDecimal pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return pessoa_id == pessoa.pessoa_id && Objects.equals(nome, pessoa.nome) && Objects.equals(cidade, pessoa.cidade) && Objects.equals(endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoa_id, nome, cidade, endereco);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoa_id=" + pessoa_id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
