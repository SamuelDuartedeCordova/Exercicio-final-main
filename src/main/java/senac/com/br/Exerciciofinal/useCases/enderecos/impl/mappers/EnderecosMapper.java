package senac.com.br.Exerciciofinal.useCases.enderecos.impl.mappers;


import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosRequestDom;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosResponseDom;

public class EnderecosMapper {
    public static EnderecosResponseDom enderecoToEnderecoResponseDom(Endereco endereco){
        EnderecosResponseDom out = new EnderecosResponseDom();
        out.setId(endereco.getId());
        out.setBairro(endereco.getBairro());
        out.setCidade(endereco.getCidade());
        out.setRua(endereco.getRua());
        out.setEstado(endereco.getEstado());
        out.setClienteId(endereco.getClientes().getId());

        return out;
    }

    public static Endereco enderecoResquestDomToEndereco(EnderecosRequestDom enderecos,
                                                         Cliente cliente){
        Endereco out = new Endereco();
        out.setBairro(enderecos.getBairro());
        out.setRua(enderecos.getRua());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());
        out.setClientes(cliente);

        return out;
    }
}
