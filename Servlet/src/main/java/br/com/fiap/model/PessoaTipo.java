package br.com.fiap.model;

import java.util.Objects;

public class PessoaTipo extends Pessoa {
    private String tipo;
    private String cpf;
    private String rg;
    private String cnpj;
    private String razaosocial;

    public PessoaTipo() {
        // Construtor padrão
    }

    public PessoaTipo(String nome, String cidade, String endereco, String tipo, String cpf, String rg, String cnpj, String razaosocial) {
        super(nome, cidade, endereco);
        this.tipo = tipo;
        this.cpf = cpf;
        this.rg = rg;
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaTipo that = (PessoaTipo) o;
        return Objects.equals(tipo, that.tipo) &&
               Objects.equals(cpf, that.cpf) &&
               Objects.equals(rg, that.rg) &&
               Objects.equals(cnpj, that.cnpj) &&
               Objects.equals(razaosocial, that.razaosocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipo, cpf, rg, cnpj, razaosocial);
    }

    @Override
    public String toString() {
        return "PessoaTipo{" +
                "tipo='" + tipo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaosocial='" + razaosocial + '\'' +
                "} " + super.toString();
    }
}

