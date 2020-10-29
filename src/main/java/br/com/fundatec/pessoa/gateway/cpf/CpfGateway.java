package br.com.fundatec.pessoa.gateway.cpf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CpfGateway {

    @Value("${gateway.cpf.url}")
    private String url;

    public Boolean existsPendencia(String cpf) {
        WebClient webClient = WebClient.create(url);

        return webClient.get()
                .uri("/cpf/" + cpf)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

}
