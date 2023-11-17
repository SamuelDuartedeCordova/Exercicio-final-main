package senac.com.br.Exerciciofinal.useCases.clientes.impl;


import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.frameWork.annotations.Business;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.frameWork.utils.StringUtil;
import senac.com.br.Exerciciofinal.useCases.clientes.ClientesBusiness;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;
import senac.com.br.Exerciciofinal.useCases.clientes.impl.mappers.ClientesMapper;
import senac.com.br.Exerciciofinal.useCases.clientes.impl.repositories.ClientesEnderecosRespository;
import senac.com.br.Exerciciofinal.useCases.clientes.impl.repositories.ClientesRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class ClientesBusinessImpl implements ClientesBusiness {

    @Autowired
    private ClientesRespository clientesRepository;

    @Autowired
    private ClientesEnderecosRespository clientesEnderecosRespository;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        List<Cliente> clienteList = clientesRepository.findAll();

        return clienteList
                .stream()
                .map(ClientesMapper::clienteToClienteResponseDom)
                .collect(Collectors.toList());
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom)
            throws SenacException {
        List<String> messages = this.validacaoManutencaoCliente(clientesRequestDom);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Cliente cliente = ClientesMapper.clienteRequestDomToCliente(clientesRequestDom);

        Cliente resultCliente = clientesRepository.save(cliente);

        return ClientesMapper.clienteToClienteResponseDom(resultCliente);
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom)
            throws SenacException {
        List<String> messages = this.validacaoManutencaoCliente(clientesRequestDom);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Optional<Cliente> clientes = clientesRepository.findById(id).map(record -> {
           record.setSobreNome(clientesRequestDom.getSobrenome());
           record.setNome(clientesRequestDom.getNome());
           record.setEmail(clientesRequestDom.getEmail());
           record.setTelefone(clientesRequestDom.getTelefone());
           record.setDataNascimento(clientesRequestDom.getDataNascimento());
           return clientesRepository.save(record);
        });

        if(clientes.isEmpty()){
            throw new SenacException("Cliente informando não existe!");
        }

        return ClientesMapper.clienteToClienteResponseDom(clientes.get());
    }

    @Override
    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }

    @Override
    public ClientesResponseDom carregarClienteById(Long id) throws SenacException {
        Cliente cliente = clientesRepository.findById(id).orElseThrow(() -> new SenacException("Cliente não encontrado"));

        List<Endereco> enderecos = clientesEnderecosRespository.carregarEnderecosByClienteId(id);

        return ClientesMapper.clienteToClienteResponseDom(cliente, enderecos);
    }

    private List<String> validacaoManutencaoCliente(ClientesRequestDom cliente){
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarString(cliente.getNome())){
            messages.add("Cliente informado não possui nome!");
        }

        if(StringUtil.validarString(cliente.getSobrenome())){
            messages.add("Cliente informado não possui sobrenome!");
        }

        if(StringUtil.validarString(cliente.getEmail())){
            messages.add("Cliente informado não possui email!");
        }

        return messages;
    }

}
