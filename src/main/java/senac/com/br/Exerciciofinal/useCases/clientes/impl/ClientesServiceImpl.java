package senac.com.br.Exerciciofinal.useCases.clientes.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.clientes.ClientesBusiness;
import senac.com.br.Exerciciofinal.useCases.clientes.ClientesService;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesBusiness clientesBusiness;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return clientesBusiness.carregarClientes();
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) throws SenacException {
        return clientesBusiness.criarCliente(clientesRequestDom);
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom)
            throws SenacException {
        return clientesBusiness.atualizarCliente(id, clientesRequestDom);
    }

    @Override
    public void deletarCliente(Long id) {
        clientesBusiness.deletarCliente(id);
    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) throws SenacException {
        return clientesBusiness.carregarClienteById(id);
    }
}
