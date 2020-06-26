package br.com.P2.controller;

import br.com.P2.constant.Constants;
import br.com.P2.model.Ferramenta;
import br.com.P2.service.FerramentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    @PostMapping(Constants.API_FERRAMENTA)
    public void save(@RequestBody Ferramenta ferramenta) {
        ferramentaService.sendFerramentaRabbit(ferramenta);
    }

    @GetMapping(Constants.API_FERRAMENTA)
    public List<Ferramenta> findAll() {
        return ferramentaService.findAll();
    }

    @PutMapping(Constants.API_FERRAMENTA)
    public Ferramenta update(@RequestBody Ferramenta ferramenta) {
        return ferramentaService.save(ferramenta);
    }

    @DeleteMapping(Constants.API_FERRAMENTA + "/{Id}")
    public void delete(@PathVariable("Id") String Id){
        ferramentaService.delete(Id);
    }

    @GetMapping(Constants.API_FERRAMENTA + "/{Id}")
    public Optional<Ferramenta> findById(@PathVariable("Id") String Id){
        return ferramentaService.findById(Id);
    }
}
