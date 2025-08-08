package br.com.qualquercois1.backend; // Ou o seu pacote correto

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    // <<< COLE O CÓDIGO AQUI DENTRO >>>
    @Bean
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            // Pega a porta do servidor do ambiente Spring
            String serverPort = environment.getProperty("local.server.port");

            // Imprime a mensagem simples e direta no console
            System.out.println("\n"); // Linha em branco para separar
            System.out.println(">> APLICAÇÃO PRONTA! ACESSE EM: http://localhost:" + serverPort);
            System.out.println("\n");
        };
    }
}