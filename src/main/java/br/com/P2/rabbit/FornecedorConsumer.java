package br.com.P2.rabbit;

import br.com.P2.model.Fornecedor;
import br.com.P2.service.FornecedorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FornecedorConsumer {

    @Autowired
    private FornecedorService fornecedorService;

    @RabbitListener(queues = {"${queue.fornecedor.name}"})
    public void receive (Fornecedor fornecedor) {
        System.out.println("id: " + fornecedor.getId() + "\nnome: " + fornecedor.getNome());
        fornecedorService.save(fornecedor);
    }
}
