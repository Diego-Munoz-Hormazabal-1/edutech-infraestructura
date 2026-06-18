package com.example.Curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    /**
     * Configuración del WebClient para comunicarse con el Microservicio de Usuario.
     * Se usa el nombre 'usuarioWebClient' para evitar confusiones ahora que 
     * no usamos el de contenido.
     */
    @Bean
    public WebClient usuarioWebClient() {
        return WebClient.builder()
                // Usamos el puerto 5000 definido en el application.properties de Usuario
                .baseUrl("http://localhost:5000") 
                .build();
    }
}
