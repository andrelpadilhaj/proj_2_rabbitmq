package br.com.P2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class MyApplication {

    @Value("${queue.ferramenta.name}")
    private String ferramentaQueue;

    @Value("${queue.fornecedor.name}")
    private String fornecedorQueue;

    public static void main(String[] args) {
        SpringApplication.run(br.com.P2.MyApplication.class, args);
    }
    @Bean
    public Queue queueFerramenta() {
        return new Queue(ferramentaQueue, true);
    }

    @Bean
    public Queue queueFornecedor() {
        return new Queue(fornecedorQueue, true);
    }

}
