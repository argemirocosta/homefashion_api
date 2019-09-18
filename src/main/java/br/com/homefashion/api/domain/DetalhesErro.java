package br.com.homefashion.api.domain;

import java.util.Objects;

public class DetalhesErro {

    private Integer status;
    private String mensagem;
    private Long timestamp;

    public DetalhesErro(Integer status, String mensagem, Long timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesErro that = (DetalhesErro) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(mensagem, that.mensagem) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, mensagem, timestamp);
    }

    @Override
    public String toString() {
        return "DetalhesErro{" +
                "status=" + status +
                ", mensagem='" + mensagem + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
