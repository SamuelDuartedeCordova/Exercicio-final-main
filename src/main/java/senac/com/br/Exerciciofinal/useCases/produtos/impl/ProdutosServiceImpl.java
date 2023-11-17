package senac.com.br.Exerciciofinal.useCases.produtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.produtos.ProdutosService;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosResponseDom;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {
    @Autowired
    private ProdutosBusinessImpl produtosBusinessImpl;

    @Override
    public ProdutosResponseDom criarProduto(ProdutosRequestDom produtosRequestDom) throws SenacException {
        return produtosBusinessImpl.criarPedido(produtosRequestDom);
    }
    @Override
    public List<ProdutosResponseDom> carregarProdutos(){
        return produtosBusinessImpl.carregarProdutos();
    }

    @Override
    public ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtosRequestDom)
            throws SenacException {
        return produtosBusinessImpl.atualizarProdutos(id, produtosRequestDom);
    }
    @Override
    public void deletarCliente(Long id) {
        produtosBusinessImpl.deletarProduto(id);
    }
    @Override
    public ProdutosResponseDom carregarProdutoById(Long id) {
        return produtosBusinessImpl.carregarProdutoById(id);
    }
}
