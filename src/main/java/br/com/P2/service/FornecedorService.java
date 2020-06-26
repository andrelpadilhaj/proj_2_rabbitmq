package br.com.P2.service;

import br.com.P2.model.Fornecedor;
import br.com.P2.rabbit.FornecedorProducer;
import br.com.P2.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorProducer fornecedorProducer;

    public void sendFornecedorRabbit(Fornecedor fornecedor) {
        fornecedorProducer.send(fornecedor);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(String Id) {
        return fornecedorRepository.findById(Integer.parseInt(Id));
    }

    public void delete(String Id) {
        fornecedorRepository.deleteById(Integer.parseInt(Id));
    }
}
