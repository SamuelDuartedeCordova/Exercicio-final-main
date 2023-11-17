package senac.com.br.Exerciciofinal.useCases.pedidos.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Exerciciofinal.entities.Pedidos;
@Repository
public interface PedidosRepository extends JpaRepository <Pedidos, Long> {
}
