package br.org.massapp.api.repository;

import br.org.massapp.api.model.Clerigo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClerigoRepository implements PanacheRepository<Clerigo> { }
