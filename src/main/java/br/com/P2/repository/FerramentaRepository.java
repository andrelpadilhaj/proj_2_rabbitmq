package br.com.P2.repository;

import br.com.P2.model.Ferramenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FerramentaRepository extends MongoRepository<Ferramenta, Integer> {
}
