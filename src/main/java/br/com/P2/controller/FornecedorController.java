package br.com.P2.controller;

import br.com.P2.constant.Constants;
import br.com.P2.model.Fornecedor;
import br.com.P2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping(Constants.API_FORNECEDOR)
    public void save(@RequestBody Fornecedor fornecedor) {
        fornecedorService.sendFornecedorRabbit(fornecedor);
    }

    @GetMapping(Constants.API_FORNECEDOR)
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();
    }

    @PutMapping(Constants.API_FORNECEDOR)
    public Fornecedor update(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @DeleteMapping(Constants.API_FORNECEDOR + "/{Id}")
    public void delete(@PathVariable("Id") String Id){
        fornecedorService.delete(Id);
    }

    @GetMapping(Constants.API_FORNECEDOR + "/{Id}")
    public Optional<Fornecedor> findById(@PathVariable("Id") String Id){
        return fornecedorService.findById(Id);
    }
}
