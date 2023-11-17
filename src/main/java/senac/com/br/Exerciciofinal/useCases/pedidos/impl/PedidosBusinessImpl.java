package senac.com.br.Exerciciofinal.useCases.pedidos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.entities.Pedidos;
import senac.com.br.Exerciciofinal.frameWork.annotations.Business;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.frameWork.utils.StringUtil;
import senac.com.br.Exerciciofinal.useCases.pedidos.PedidosBusiness;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.impl.mappers.PedidosMapper;
import senac.com.br.Exerciciofinal.useCases.pedidos.impl.repositories.PedidosRepository;

import java.util.ArrayList;
import java.util.List;

@Business
public class PedidosBusinessImpl implements PedidosBusiness {

    @Autowired
    private PedidosRepository pedidosRepository;


    public PedidosResponseDom criarPedido(PedidosRequestDom pedidosRequestDom, Endereco endereco,
                                          Cliente cliente)
        throws SenacException{
        List <String> messages = this.validacaoManutencaoPedidos(pedidosRequestDom);

        if (messages.isEmpty()){
            throw new SenacException(messages);
        }
        Pedidos pedido = PedidosMapper.pedidoRequestDomParaPedido
                (pedidosRequestDom, endereco, cliente);
        Pedidos resultPedido = pedidosRepository.save(pedido);

        PedidosResponseDom out = PedidosMapper.pedidoParaPedidoResponseDom(resultPedido);

        return out;

    }

    private List<String> validacaoManutencaoPedidos(PedidosRequestDom pedidosRequestDom){
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarLocalDateTime(pedidosRequestDom.getDataCriacao())){
            messages.add("Pedido informado não possui data de criação!");
        }


        return messages;
    }

    @Override
    public PedidosResponseDom criarPedido(PedidosRequestDom pedidosRequestDom) throws Exception {
        return null; // TODO: Implementar lógica
    }
}
