package io.github.dougllasfps;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.dougllasfps.domain.entity.Cliente;
import io.github.dougllasfps.domain.entity.Funcionario;
import io.github.dougllasfps.domain.entity.Pedido;
import io.github.dougllasfps.domain.repository.Clientes;
import io.github.dougllasfps.domain.repository.Funcionarios;
import io.github.dougllasfps.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos,
            @Autowired Funcionarios funcionarios
        
    ) {
        return args -> {
            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("Fulano");
            clientes.save(fulano);
            Funcionario funcionario = new Funcionario();
            funcionario.setNome("Rubinho ALVES SOARES2");
            funcionario.setEmail("rubinhocavacanti2020@gmail.com2");
            
            funcionarios.save(funcionario);
            funcionario.getNome();
            funcionario.getEmail();
            funcionario.setDataAtual(LocalDate.now());
            funcionarios.save(funcionario);
            


            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(fulano).forEach(System.out::println);



        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
