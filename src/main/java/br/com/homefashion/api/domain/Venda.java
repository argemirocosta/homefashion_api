package br.com.homefashion.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(schema = "vendas", name = "venda")
@Entity
public class Venda implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "valor")
    private Double valor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "qtd")
    private Integer qtd;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data")
    private Date data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "usuario")
    private Integer idUsuario;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "cancelada")
    private Boolean cancelada;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_hora_cancelamento")
    private Date dataHoraCancelamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Date getDataHoraCancelamento() {
        return dataHoraCancelamento;
    }

    public void setDataHoraCancelamento(Date dataHoraCancelamento) {
        this.dataHoraCancelamento = dataHoraCancelamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) &&
                Objects.equals(idCliente, venda.idCliente) &&
                Objects.equals(valor, venda.valor) &&
                Objects.equals(qtd, venda.qtd) &&
                Objects.equals(data, venda.data) &&
                Objects.equals(idUsuario, venda.idUsuario) &&
                Objects.equals(cancelada, venda.cancelada) &&
                Objects.equals(dataHoraCancelamento, venda.dataHoraCancelamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCliente, valor, qtd, data, idUsuario, cancelada, dataHoraCancelamento);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", valor=" + valor +
                ", qtd=" + qtd +
                ", data=" + data +
                ", idUsuario=" + idUsuario +
                ", cancelada=" + cancelada +
                ", dataHoraCancelamento=" + dataHoraCancelamento +
                '}';
    }
}
