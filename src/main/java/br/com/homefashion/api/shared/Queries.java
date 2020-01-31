package br.com.homefashion.api.shared;

public class Queries {

    private Queries() {}

    public static final String CONSULTA_VENDAS_POR_USUARIO =
            "SELECT v FROM Venda v WHERE usuario = :codigoUsuario";

    public static final String CONSULTA_CLIENTES_POR_USUARIO =
            "SELECT c FROM Cliente c WHERE usuario.id = :codigoUsuario ORDER BY c.nome";

    public static final String CONSULTA_PAGAMENTOS_POR_VENDA =
            "SELECT p FROM Pagamento p WHERE idVenda = :codigoVenda";

    public static final String CONSULTA_PAGAMENTOS_POR_CLIENTE =
            "SELECT p.id, p.valor_pago, p.id_venda, p.usuario, p.data_pagamento, p.cancelada, p.data_hora_cancelamento " +
                    "FROM vendas.pagamentos p " +
                    "JOIN vendas.venda v ON (p.id_venda = v.id) " +
                    "WHERE v.id_cliente = :codigoCliente";

    public static final String ALTERAR_CANCELAR_PAGAMENTO =
            "UPDATE vendas.pagamentos SET cancelada = TRUE, data_hora_cancelamento = current_timestamp WHERE id = :codigoPagamento";

    public static final String ALTERAR_CANCELAR_VENDA =
            "UPDATE vendas.venda SET cancelada = TRUE, data_hora_cancelamento = current_timestamp WHERE id = :codigoVenda";

}
