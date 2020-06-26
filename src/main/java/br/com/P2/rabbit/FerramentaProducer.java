package br.com.P2.rabbit;

import br.com.P2.model.Ferramenta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
public class FerramentaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queueFerramenta")
    @Autowired
    private Queue queue;

    public void send(Ferramenta ferramenta) {
        rabbitTemplate.convertAndSend(this.queue.getName(), ferramenta);
    }
}
