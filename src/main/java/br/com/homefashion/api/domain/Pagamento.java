package br.com.homefashion.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(schema = "vendas", name = "pagamentos")
@Entity
public class Pagamento implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "id_venda")
    private Integer idVenda;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "valor_pago")
    private Double valorPago;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

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

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) &&
                Objects.equals(idVenda, pagamento.idVenda) &&
                Objects.equals(valorPago, pagamento.valorPago) &&
                Objects.equals(dataPagamento, pagamento.dataPagamento) &&
                Objects.equals(usuario, pagamento.usuario) &&
                Objects.equals(cancelada, pagamento.cancelada) &&
                Objects.equals(dataHoraCancelamento, pagamento.dataHoraCancelamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idVenda, valorPago, dataPagamento, usuario, cancelada, dataHoraCancelamento);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", idVenda=" + idVenda +
                ", valorPago=" + valorPago +
                ", dataPagamento=" + dataPagamento +
                ", usuario=" + usuario +
                ", cancelada=" + cancelada +
                ", dataHoraCancelamento=" + dataHoraCancelamento +
                '}';
    }
}
