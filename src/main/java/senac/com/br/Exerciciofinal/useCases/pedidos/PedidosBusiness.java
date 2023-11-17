package senac.com.br.Exerciciofinal.useCases.pedidos;

import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;

public interface PedidosBusiness {
    PedidosResponseDom criarPedido(PedidosRequestDom pedidosRequestDom) throws Exception;
}
