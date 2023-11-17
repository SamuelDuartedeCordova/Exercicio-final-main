package senac.com.br.Exerciciofinal.useCases.pedidos;

import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;

@Service
public interface PedidosService {
    PedidosResponseDom criarPedido (PedidosRequestDom pedidosRequestDom) throws Exception;
}
