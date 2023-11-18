package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.Objects;

public class PessoaFisica extends Pessoa {
    private BigDecimal pf_id;
    private String rg;
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cidade, String endereco, String rg, String cpf) {
        super(nome, cidade, endereco);
        this.rg = rg;
        this.cpf = cpf;
    }

    public BigDecimal getPf_id() {
        return pf_id;
    }

    public void setPf_id(BigDecimal pf_id) {
        this.pf_id = pf_id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return pf_id == that.pf_id && Objects.equals(rg, that.rg) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pf_id, rg, cpf);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "pf_id=" + pf_id +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
