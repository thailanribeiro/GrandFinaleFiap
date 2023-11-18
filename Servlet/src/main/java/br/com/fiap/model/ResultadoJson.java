package br.com.fiap.model;

import java.util.List;

public class ResultadoJson {
    private List<PessoaFisica> pessoasFisicas;
    private List<PessoaJuridica> pessoasJuridicas;

    public ResultadoJson(List<PessoaFisica> pessoasFisicas, List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasFisicas = pessoasFisicas;
        this.pessoasJuridicas = pessoasJuridicas;
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }
}
