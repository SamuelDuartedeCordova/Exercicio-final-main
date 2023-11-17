package senac.com.br.Exerciciofinal.useCases.clientes.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Exerciciofinal.entities.Cliente;

@Repository
public interface ClientesRespository extends JpaRepository<Cliente, Long> {
}
