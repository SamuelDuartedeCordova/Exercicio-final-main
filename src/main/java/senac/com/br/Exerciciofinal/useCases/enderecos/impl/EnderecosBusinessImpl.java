package senac.com.br.Exerciciofinal.useCases.enderecos.impl;


import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Exerciciofinal.entities.Cliente;
import senac.com.br.Exerciciofinal.entities.Endereco;
import senac.com.br.Exerciciofinal.frameWork.annotations.Business;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.enderecos.EnderecosBusiness;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosRequestDom;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosResponseDom;
import senac.com.br.Exerciciofinal.useCases.enderecos.impl.mappers.EnderecosMapper;
import senac.com.br.Exerciciofinal.useCases.enderecos.impl.repositories.EnderecosClientesRepository;
import senac.com.br.Exerciciofinal.useCases.enderecos.impl.repositories.EnderecosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class EnderecosBusinessImpl implements EnderecosBusiness {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private EnderecosClientesRepository enderecosClientesRepository;

    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {
        List<Endereco> enderecoList =enderecosRepository.findAll();

        return enderecoList.stream()
                .map(EnderecosMapper::enderecoToEnderecoResponseDom)
                .collect(Collectors.toList());
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws SenacException {
        List<String> messages = this.validacaoManutencaoEndereco(endereco);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Optional<Cliente> cliente = enderecosClientesRepository.findById(endereco.getClienteId());
        if(cliente.isEmpty()){
            throw new SenacException("Cliente não encontrado");
        }

        Endereco enderecoRetorno = enderecosRepository.save(EnderecosMapper.enderecoResquestDomToEndereco(endereco, cliente.get()));

        return EnderecosMapper.enderecoToEnderecoResponseDom(enderecoRetorno);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws SenacException {
        List<String> messages = this.validacaoManutencaoEndereco(endereco);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Optional<Cliente> cliente;
        cliente = enderecosClientesRepository.findById(endereco.getClienteId());
        if(cliente.isEmpty()){
            throw new SenacException("Cliente não encontrado");
        }

        Optional<Endereco> enderecoRetorno = enderecosRepository.findById(id).map(record -> {
            record.setRua(endereco.getRua());
            record.setBairro(endereco.getBairro());
            record.setCidade(endereco.getCidade());
            record.setEstado(endereco.getEstado());
            record.setClientes(cliente.get());
            return enderecosRepository.save(record);
        });

        if(enderecoRetorno.isEmpty()){
            throw new SenacException("Endereço não encontrado");
        }

        return EnderecosMapper.enderecoToEnderecoResponseDom(enderecoRetorno.get());
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosRepository.deleteById(id);
    }

    private List<String> validacaoManutencaoEndereco(EnderecosRequestDom endereco){
        List<String> messages = new ArrayList<>();

        if(endereco.getBairro() == null || Objects.equals(endereco.getBairro(), "")){
            messages.add("Bairro não informa!");
        }

        if(endereco.getEstado() == null || Objects.equals(endereco.getEstado(), "")){
            messages.add("Estado não informa!");
        }
        if(endereco.getCidade() == null || Objects.equals(endereco.getCidade(), "")){
            messages.add("Cidade não informa!");
        }
        if(endereco.getRua() == null || Objects.equals(endereco.getRua(), "")){
            messages.add("Rua não informa!");
        }

        if(endereco.getClienteId() == null || endereco.getClienteId() < 1){
            messages.add("ClienteId não informa ou valor invalido!");
        }

        return messages;
    }
}
