package senac.com.br.Exerciciofinal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"senac.com.br.Exerciciofinal",
		"senac.com.br.Exerciciofinal.useCases.pedidos"})
public class ExercicioFinalApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExercicioFinalApplication.class, args);
	}

}
