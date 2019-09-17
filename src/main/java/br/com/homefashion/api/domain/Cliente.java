package br.com.homefashion.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(schema = "vendas", name = "clientes")
@Entity
public class Cliente implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "nome")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "cpf")
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "rg")
    private String rg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "telefone1")
    private Integer telefone1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "telefone2")
    private Integer telefone2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "usuario")
    private Integer usuario;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Endereco endereco;

    public Cliente() {
        endereco = new Endereco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Integer telefone1) {
        this.telefone1 = telefone1;
    }

    public Integer getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Integer telefone2) {
        this.telefone2 = telefone2;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nome, cliente.nome) &&
                Objects.equals(dataNascimento, cliente.dataNascimento) &&
                Objects.equals(cpf, cliente.cpf) &&
                Objects.equals(rg, cliente.rg) &&
                Objects.equals(telefone1, cliente.telefone1) &&
                Objects.equals(telefone2, cliente.telefone2) &&
                Objects.equals(usuario, cliente.usuario) &&
                Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, cpf, rg, telefone1, telefone2, usuario, endereco);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", telefone1=" + telefone1 +
                ", telefone2=" + telefone2 +
                ", usuario=" + usuario +
                ", endereco=" + endereco +
                '}';
    }
}
