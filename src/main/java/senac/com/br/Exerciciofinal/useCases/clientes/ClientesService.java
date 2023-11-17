package senac.com.br.Exerciciofinal.useCases.clientes;


import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;

import java.util.List;

@Service
public interface ClientesService {
    List<ClientesResponseDom> carregarClientes();
    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws Exception;
    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom) throws SenacException, SenacException;
    void deletarCliente(Long id);
    ClientesResponseDom carregarClienteById(Long id) throws SenacException;
}
