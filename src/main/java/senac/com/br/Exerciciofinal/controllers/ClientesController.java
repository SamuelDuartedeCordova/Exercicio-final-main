package senac.com.br.Exerciciofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Exerciciofinal.frameWork.annotations.LogRest;
import senac.com.br.Exerciciofinal.frameWork.utils.ResponseUtil;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.clientes.ClientesService;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesRequestDom;
import senac.com.br.Exerciciofinal.useCases.clientes.domains.ClientesResponseDom;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping(path = "/carregar")
    @LogRest
    public ResponseEntity<List<ClientesResponseDom>> carregarClientes(){
        return ResponseEntity.ok(clientesService.carregarClientes());
    }

    @GetMapping("/carregar/{id}")
    @LogRest
    public ResponseEntity<ClientesResponseDom> carregarClienteById(@PathVariable Long id)
            throws SenacException {
        return ResponseEntity.ok(clientesService.carregarClienteById(id));
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarCliente
            (@RequestBody ClientesRequestDom clientesRequestDom){

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body
                    (clientesService.criarCliente(clientesRequestDom));
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

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<?> atualizarCliente
            (@PathVariable Long id,
             @RequestBody ClientesRequestDom clientesRequestDom){
        try {
            return ResponseEntity.ok(
                    clientesService.atualizarCliente(id, clientesRequestDom));
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
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clientesService.deletarCliente(id);

        return ResponseEntity.ok(null);
    }
}
