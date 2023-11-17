package senac.com.br.Exerciciofinal.useCases.clientes.impl.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import senac.com.br.Exerciciofinal.entities.Endereco;

import java.util.List;

public interface ClientesEnderecosRespository extends JpaRepository<Endereco, Long> {
    @Query("select a from enderecos a where a.cliente.id = :id")
    List<Endereco> carregarEnderecosByClienteId(@Param("id") Long id);
}
