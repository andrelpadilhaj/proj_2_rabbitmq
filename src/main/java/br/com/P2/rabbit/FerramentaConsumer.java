package br.com.P2.rabbit;

import br.com.P2.model.Ferramenta;
import br.com.P2.service.FerramentaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FerramentaConsumer {

    @Autowired
    private FerramentaService ferramentaService;

    @RabbitListener(queues = {"${queue.ferramenta.name}"})
    public void receive (@Payload Ferramenta ferramenta) {
        System.out.println("id: " + ferramenta.getId() + "\nnome: " + ferramenta.getDescricao());
        ferramentaService.save(ferramenta);
    }
}
