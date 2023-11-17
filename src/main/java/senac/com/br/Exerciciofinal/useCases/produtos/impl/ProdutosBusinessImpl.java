package senac.com.br.Exerciciofinal.useCases.produtos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import senac.com.br.Exerciciofinal.entities.Produtos;
import senac.com.br.Exerciciofinal.frameWork.annotations.Business;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.frameWork.utils.StringUtil;
import senac.com.br.Exerciciofinal.useCases.produtos.ProdutosBusiness;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosResponseDom;
import senac.com.br.Exerciciofinal.useCases.produtos.impl.mappers.ProdutosMapper;
import senac.com.br.Exerciciofinal.useCases.produtos.impl.repositories.ProdutosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Business
public class ProdutosBusinessImpl implements ProdutosBusiness {

    @Autowired
    ProdutosRepository produtosRepository;

    public ProdutosResponseDom criarPedido(ProdutosRequestDom produtosRequestDom) throws SenacException {
        List<String> messages = this.validacaoManutencaoProdutos(produtosRequestDom);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Produtos produtos = ProdutosMapper.produtosRequestDomParaProdutos(produtosRequestDom);

        Produtos resultProdutos;
        resultProdutos = produtosRepository.save(produtos);

       ProdutosResponseDom out = ProdutosMapper.produtosParaProdutosResponseDom(resultProdutos);

        return out;
    }
    @Override
    public List<ProdutosResponseDom> carregarProdutos() {
        List<Produtos> produtosList = produtosRepository.findAll();

        List<ProdutosResponseDom> out = produtosList
                .stream()
                .map(ProdutosMapper :: produtosParaProdutosResponseDom)
                .collect(Collectors.toList());

        return out;
    }

    @Override
    public ProdutosResponseDom atualizarProdutos(Long id, ProdutosRequestDom produtosRequestDom)
            throws SenacException {
        List<String> messages = this.validacaoManutencaoProdutos(produtosRequestDom);

        if(!messages.isEmpty()){
            throw new SenacException(messages);
        }

        Optional<Produtos> produtos = produtosRepository.findById(id).map(record -> {
            record.setNome(produtosRequestDom.getNome());
            record.setDescricao(produtosRequestDom.getDescricao());
            return produtosRepository.save(record);
        });

        if(!produtos.isPresent()){
            throw new SenacException("Produto informando não existe!");
        }

        ProdutosResponseDom out =
                ProdutosMapper.produtosParaProdutosResponseDom(produtos.get());

        return out;
    }

    private List<String> validacaoManutencaoProdutos(ProdutosRequestDom produtosRequestDom){
        List<String> messages = new ArrayList<>();

        if(StringUtil.validarString(produtosRequestDom.getNome())){
            messages.add("Produto informado não possui nome!");
        }

        if(StringUtil.validarString(produtosRequestDom.getDescricao())){
            messages.add("Produto informado não possui descrição!");
        }

        return messages;
    }
    @Override
    public void deletarProduto(Long id) {
        produtosRepository.deleteById(id);
    }
    @Override
    public ProdutosResponseDom carregarProdutoById(Long id) {
        Produtos produtos = produtosRepository.findById(id).get();

        ProdutosResponseDom out = ProdutosMapper.produtosParaProdutosResponseDom(produtos);

        return out;
    }
}
