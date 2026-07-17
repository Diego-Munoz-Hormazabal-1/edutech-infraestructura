package com.example.Usuario;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class UsuarioApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UsuarioApplication.class)
                .web(WebApplicationType.SERVLET) // Fuerza el modo Servlet tradicional para que AWS Lambda funcione impecable
                .run(args);
    }
}