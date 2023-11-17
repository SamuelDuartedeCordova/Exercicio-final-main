package senac.com.br.Exerciciofinal.useCases.pedidos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.useCases.pedidos.PedidosService;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosBusinessImpl pedidosBusinessImpl;

    @Override
    public PedidosResponseDom criarPedido(PedidosRequestDom pedidosRequestDom) throws Exception {
        return pedidosBusinessImpl.criarPedido(pedidosRequestDom);
    }
}
