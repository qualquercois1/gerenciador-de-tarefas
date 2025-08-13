package br.com.qualquercois1.backend.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component // 1. Marca esta classe como um Componente Spring para ser gerenciada pelo framework.
public class AppStartupListener implements ApplicationListener<ApplicationReadyEvent> {

    // 2. Usamos um Logger para imprimir mensagens, que é a melhor prática em vez de System.out.println().
    private static final Logger log = LoggerFactory.getLogger(AppStartupListener.class);

    private final Environment environment;

    // 3. Injetamos o Environment para ter acesso às propriedades da aplicação, como a porta do servidor.
    public AppStartupListener(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // 4. Este método é executado QUANDO a aplicação está 100% pronta.
        try {
            String serverPort = environment.getProperty("local.server.port");
            String hostAddress = InetAddress.getLocalHost().getHostAddress();

            log.info("\n\n----------------------------------------------------------\n" +
                            "\tAplicação iniciada com sucesso! Acesse em:\n" +
                            "\tLocal: \t\thttp://localhost:{}\n" +
                            "\tNa rede: \thttp://{}:{}\n" +
                            "----------------------------------------------------------\n",
                    serverPort, hostAddress, serverPort);

        } catch (UnknownHostException e) {
            log.error("Não foi possível obter o endereço de host.", e);
        }
    }
}