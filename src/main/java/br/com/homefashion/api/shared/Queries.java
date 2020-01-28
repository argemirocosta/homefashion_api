package br.com.homefashion.api.shared;

public class Queries {

    private Queries() {}

    public static final String CONSULTA_VENDAS_POR_USUARIO =
            "SELECT v FROM Venda v WHERE usuario = :codigoUsuario";

}
