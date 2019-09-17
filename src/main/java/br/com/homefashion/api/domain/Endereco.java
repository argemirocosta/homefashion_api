package br.com.homefashion.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Objects;

public class Endereco {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cep;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bairro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String logradouro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer numero;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer codIBGE;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ArrayList<String> listaEstados;

    public Endereco() {
        //popularListaDeEstados();
    }

    private void popularListaDeEstados(){
        listaEstados = new ArrayList<>();
        listaEstados.add("AC");
        listaEstados.add("AL");
        listaEstados.add("AM");
        listaEstados.add("AP");
        listaEstados.add("BA");
        listaEstados.add("CE");
        listaEstados.add("DF");
        listaEstados.add("ES");
        listaEstados.add("GO");
        listaEstados.add("MA");
        listaEstados.add("MG");
        listaEstados.add("MS");
        listaEstados.add("MT");
        listaEstados.add("PA");
        listaEstados.add("PB");
        listaEstados.add("PE");
        listaEstados.add("PI");
        listaEstados.add("PR");
        listaEstados.add("RJ");
        listaEstados.add("RN");
        listaEstados.add("RO");
        listaEstados.add("RR");
        listaEstados.add("RS");
        listaEstados.add("SC");
        listaEstados.add("SE");
        listaEstados.add("SP");
        listaEstados.add("TO");
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(Integer codIBGE) {
        this.codIBGE = codIBGE;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ArrayList<String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ArrayList<String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(cep, endereco.cep) &&
                Objects.equals(estado, endereco.estado) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(logradouro, endereco.logradouro) &&
                Objects.equals(numero, endereco.numero) &&
                Objects.equals(codIBGE, endereco.codIBGE) &&
                Objects.equals(listaEstados, endereco.listaEstados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, estado, cidade, bairro, logradouro, numero, codIBGE, listaEstados);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", codIBGE=" + codIBGE +
                ", listaEstados=" + listaEstados +
                '}';
    }
}
