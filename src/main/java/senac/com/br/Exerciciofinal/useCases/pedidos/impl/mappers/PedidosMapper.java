package senac.com.br.Exerciciofinal.useCases.pedidos.impl.mappers;

import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.entities.Pedidos;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;

public class PedidosMapper {
    public static Pedidos pedidoRequestDomParaPedido
            (PedidosRequestDom pedidosRequestDom, Endereco endereco, Cliente cliente){
        Pedidos out = new Pedidos();
        out.setDataCriacao(pedidosRequestDom.getDataCriacao());
        out.setDataEntrega(pedidosRequestDom.getDataEntrega());
        out.setValorDesconto(pedidosRequestDom.getValorDesconto());
        out.setEnderecos(endereco);
        out.setClientes(cliente);

        return out;
    }

    public static PedidosResponseDom pedidoParaPedidoResponseDom(Pedidos pedido){
        PedidosResponseDom out = new PedidosResponseDom();
        out.setId(pedido.getId());
        out.setDataCriacao(pedido.getDataCriacao());
        out.setDataEntrega(pedido.getDataEntrega());
        out.setValorDesconto(pedido.getValorDesconto());
        out.setClienteId(pedido.getClientes().getId());
        out.setEnderecoId(pedido.getEnderecos().getId());

        return out;
    }
}
