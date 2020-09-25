package backend;

import org.glassfish.jersey.server.ResourceConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class App extends ResourceConfig {
    public App() {
        packages("backend.controllers");
    }
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Código CRUD aqui

//    entityManager.close();
//    entityManagerFactory.close();
}


