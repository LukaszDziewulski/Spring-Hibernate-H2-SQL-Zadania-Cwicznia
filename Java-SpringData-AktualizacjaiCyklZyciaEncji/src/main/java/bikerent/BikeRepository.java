package bikerent;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class BikeRepository {

    private final EntityManager entityManager; // to moje DAO !!!

    BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Bike bike) {
            entityManager.persist(bike); // metoda persisit czyli utrwal zapisuje za pomoca entity manager obiekt w H2
        }




    public Optional<Bike> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Bike.class, id));
    }


    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
