package senac.com.br.Exerciciofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Exerciciofinal.frameWork.annotations.LogRest;
import senac.com.br.Exerciciofinal.frameWork.utils.ResponseUtil;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosRequestDom;
import senac.com.br.Exerciciofinal.useCases.produtos.domains.ProdutosResponseDom;
import senac.com.br.Exerciciofinal.useCases.produtos.impl.ProdutosServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosServiceImpl produtosServiceImpl;

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarProduto
            (@RequestBody ProdutosRequestDom produtosRequestDom){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    produtosServiceImpl.criarProduto(produtosRequestDom));
        } catch (SenacException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(ResponseUtil.responseMapper("Erro não mapeado: " + e.getMessage()));
        }
    }
    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<ProdutosResponseDom>> carregarProdutos(){
        return ResponseEntity.ok(produtosServiceImpl.carregarProdutos());
    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<?> atualizarProdutos
            (@PathVariable Long id,
             @RequestBody ProdutosRequestDom produtosRequestDom){
        try {
            return ResponseEntity.ok(
                    produtosServiceImpl.atualizarProdutos(id, produtosRequestDom));
        } catch (SenacException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(ResponseUtil.responseMapper("Erro não mapeado: " + e.getMessage()));
        }
    }
    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtosServiceImpl.deletarCliente(id);

        return ResponseEntity.ok(null);
    }
    @GetMapping("/carregar/{id}")
    @LogRest
    public ResponseEntity<ProdutosResponseDom> carregarProdutoById(@PathVariable Long id){
        return ResponseEntity.ok(produtosServiceImpl.carregarProdutoById(id));
    }
}
