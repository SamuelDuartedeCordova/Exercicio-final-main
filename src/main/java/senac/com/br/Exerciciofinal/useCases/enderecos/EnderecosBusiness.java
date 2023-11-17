package senac.com.br.Exerciciofinal.useCases.enderecos;


import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosRequestDom;
import senac.com.br.Exerciciofinal.useCases.enderecos.domains.EnderecosResponseDom;

import java.util.List;

public interface EnderecosBusiness {
    List<EnderecosResponseDom> carregarEnderecos();
    EnderecosResponseDom criarEndereco(EnderecosRequestDom endereco) throws SenacException;
    EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom endereco) throws SenacException;
    void deletarEndereco(Long id);
}
