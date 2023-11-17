package senac.com.br.Exerciciofinal.useCases.clientes;


import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;

import java.util.List;

public interface ClientesBusiness {
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws SenacException;
    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom) throws SenacException;
    void deletarCliente(Long id);
    ClientesResponseDom carregarClienteById(Long id) throws SenacException;
}
