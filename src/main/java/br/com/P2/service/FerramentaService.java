package br.com.P2.service;

import br.com.P2.model.Ferramenta;
import br.com.P2.rabbit.FerramentaProducer;
import br.com.P2.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FerramentaService {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    @Autowired
    private FerramentaProducer ferramentaProducer;

    public void sendFerramentaRabbit(Ferramenta ferramenta) {
        ferramentaProducer.send(ferramenta);
    }

    public Ferramenta save(Ferramenta ferramenta) {
        return ferramentaRepository.save(ferramenta);
    }

    public List<Ferramenta> findAll() {
        return ferramentaRepository.findAll();
    }

    public Optional<Ferramenta> findById(String Id) {
        return ferramentaRepository.findById(Integer.parseInt(Id));
    }

    public void delete(String Id) {
        ferramentaRepository.deleteById(Integer.parseInt(Id));
    }
}
