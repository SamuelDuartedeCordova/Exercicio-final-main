package senac.com.br.Exerciciofinal.useCases.produtos.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Exerciciofinal.entities.Produtos;

@Repository
public interface ProdutosRepository  extends JpaRepository <Produtos, Long> {
}
