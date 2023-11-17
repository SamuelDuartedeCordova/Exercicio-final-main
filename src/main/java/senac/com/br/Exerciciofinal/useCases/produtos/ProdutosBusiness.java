package senac.com.br.Exerciciofinal.useCases.produtos;

import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosResponseDom;

import java.util.List;

public interface ProdutosBusiness {
    List<ProdutosResponseDom> carregarProdutos();

    ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtosRequestDom)
            throws SenacException;

    void deletarProduto(Long id);

    ProdutosResponseDom carregarProdutoById(Long id);
}
