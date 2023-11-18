package br.com.fiap.model;

import java.util.Objects;

public class PessoaJuridica extends Pessoa {
    private int pj_id;
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String cidade, String endereco, String cnpj, String razaoSocial) {
        super(nome, cidade, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public int getPj_id() {
        return pj_id;
    }

    public void setPj_id(int pj_id) {
        this.pj_id = pj_id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return pj_id == that.pj_id && Objects.equals(cnpj, that.cnpj) && Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pj_id, cnpj, razaoSocial);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "pj_id=" + pj_id +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
