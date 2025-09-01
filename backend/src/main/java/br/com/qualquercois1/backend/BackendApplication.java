package br.com.qualquercois1.backend;

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

    @Bean
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            String serverPort = environment.getProperty("local.server.port");

            System.out.println("\n");
            System.out.println(">> APLICAÇÃO PRONTA! ACESSE EM: http://localhost:" + serverPort);
            System.out.println("\n");
        };
    }
}