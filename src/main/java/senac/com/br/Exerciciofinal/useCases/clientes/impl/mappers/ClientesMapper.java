package senac.com.br.Exerciciofinal.useCases.clientes.impl.mappers;

import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesEnderecosResponseDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;

import java.util.List;
import java.util.stream.Collectors;

public class ClientesMapper {
    public static ClientesResponseDom clienteToClienteResponseDom(Cliente cliente){
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(cliente.getId());
        out.setNome(cliente.getNome());
        out.setEmail(cliente.getEmail());
        out.setSobrenome(cliente.getSobreNome());
        out.setTelefone(cliente.getTelefone());
        out.setDataNascimento(cliente.getDataNascimento());

        return out;
    }

    public static ClientesResponseDom clienteToClienteResponseDom(Cliente cliente,
                                                                  List<Endereco> enderecos){
        ClientesResponseDom out = ClientesMapper.clienteToClienteResponseDom(cliente);
        List<ClientesEnderecosResponseDom> enderecosResponseDomList = enderecos.stream()
                .map(ClientesMapper::enderecoToClienteEnderecosResponseDom)
                .collect(Collectors.toList());

        out.setEnderecos(enderecosResponseDomList);

        return out;
    }

    public static Cliente clienteRequestDomToCliente
            (ClientesRequestDom clientesRequestDom){
        Cliente out = new Cliente();
        out.setDataNascimento(clientesRequestDom.getDataNascimento());
        out.setEmail(clientesRequestDom.getEmail());
        out.setNome(clientesRequestDom.getNome());
        out.setTelefone(clientesRequestDom.getTelefone());
        out.setSobreNome(clientesRequestDom.getSobrenome());

        return out;
    }

    public static ClientesEnderecosResponseDom enderecoToClienteEnderecosResponseDom(Endereco endereco){
        ClientesEnderecosResponseDom out = new ClientesEnderecosResponseDom();
        out.setId(endereco.getId());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setRua(endereco.getRua());
        out.setEstado(endereco.getEstado());

        return out;
    }
}
