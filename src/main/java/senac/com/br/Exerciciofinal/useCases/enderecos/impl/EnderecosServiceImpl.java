package senac.com.br.Exerciciofinal.useCases.enderecos.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.enderecos.EnderecosService;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosRequestDom;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosResponseDom;

import java.util.List;

@Service
public class EnderecosServiceImpl implements EnderecosService {

    @Autowired
    private EnderecosBusinessImpl enderecosBusiness;

    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {
        return
                enderecosBusiness.carregarEnderecos();
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws SenacException {
        return enderecosBusiness.criarEndereco(endereco);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws SenacException {
        return enderecosBusiness.atualizarEndereco(id, endereco);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosBusiness.deletarEndereco(id);
    }
}
