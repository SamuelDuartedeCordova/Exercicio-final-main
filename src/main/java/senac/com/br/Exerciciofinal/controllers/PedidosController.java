package senac.com.br.Exerciciofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import senac.com.br.Exerciciofinal.frameWork.annotations.LogRest;
import senac.com.br.Exerciciofinal.frameWork.utils.ResponseUtil;
import senac.com.br.Exerciciofinal.frameWork.utils.SenacException;
import senac.com.br.Exerciciofinal.useCases.pedidos.PedidosService;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosRequestDom;
import senac.com.br.Exerciciofinal.useCases.pedidos.domains.PedidosResponseDom;


@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarPedido (@RequestBody PedidosRequestDom pedidosRequestDom){
        try {
            PedidosResponseDom out = pedidosService.criarPedido(pedidosRequestDom);

            return ResponseEntity.status(HttpStatus.CREATED).body(out);

        } catch (SenacException senacException) {
            senacException.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper
                    (senacException.getMessages()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
