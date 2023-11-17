package senac.com.br.Exerciciofinal.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity(name = "pedidos_itens")
@SQLDelete(sql = "UPDATE pedidos_itens SET deleted_at = now() WHERE id=?")
@Where(clause = "deleted_at is null")

public class PedidoItens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Double quantidade;
    @Column
    private Double valorUnitario;
    @ManyToOne
    @JoinColumn(name = "produtos_id", nullable = false)
    private Produtos produto;
    @ManyToOne
    @JoinColumn(name = "pedidos_id", nullable = false)
    private Pedidos pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
