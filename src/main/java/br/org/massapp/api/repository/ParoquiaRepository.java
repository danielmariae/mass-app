package br.org.massapp.api.repository;

import br.org.massapp.api.model.paroquia.Paroquia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParoquiaRepository implements PanacheRepository<Paroquia> {
    
}
