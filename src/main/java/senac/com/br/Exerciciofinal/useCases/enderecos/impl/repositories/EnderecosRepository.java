package senac.com.br.Exerciciofinal.useCases.enderecos.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.com.br.Exerciciofinal.entities.Endereco;

@Repository
public interface EnderecosRepository extends JpaRepository<Endereco, Long> {
}
