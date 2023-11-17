package senac.com.br.Exerciciofinal.useCases.produtos.impl.mappers;

import senac.com.br.Exerciciofinal.entities.Produtos;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosResponseDom;

public class ProdutosMapper {

    public static Produtos produtosRequestDomParaProdutos
            (ProdutosRequestDom produtosRequestDom){
        Produtos out = new Produtos();

        out.setNome(produtosRequestDom.getNome());
        out.setDescricao(produtosRequestDom.getDescricao());

        return out;
    }

    public static ProdutosResponseDom produtosParaProdutosResponseDom(Produtos produtos){
        ProdutosResponseDom out = new ProdutosResponseDom();
        out.setId(produtos.getId());
        out.setNome(produtos.getNome());
        out.setDescricao(produtos.getDescricao());

        return out;
    }
}
