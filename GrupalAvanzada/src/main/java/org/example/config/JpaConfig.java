package org.example.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class JpaConfig {

    @PersistenceUnitName("bibliotecaUCE-db")
    @Inject
    EntityManagerFactory emf;

    public JpaConfig() {
        this.emf = Persistence.createEntityManagerFactory("bibliotecaUCE-db");
    }

    @Produces
    public EntityManager entityManager() {
        System.out.println("Creando EntityManager");
        return emf.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager) {
        System.out.println("\nCerrando EntityManager");
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
