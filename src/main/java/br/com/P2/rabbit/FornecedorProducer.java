package br.com.P2.rabbit;

import br.com.P2.model.Ferramenta;
import br.com.P2.model.Fornecedor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FornecedorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueFornecedor")
    @Autowired
    private Queue queue;

    public void send(Fornecedor fornecedor) {
        rabbitTemplate.convertAndSend(this.queue.getName(), fornecedor);
    }
}
