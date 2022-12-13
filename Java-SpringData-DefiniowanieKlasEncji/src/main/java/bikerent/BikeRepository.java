package bikerent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
class BikeRepository {

    private final EntityManager entityManager; // to moje DAO !!!

    BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

@Transactional
    public void save(Bike bike) {
        entityManager.persist(bike); // metoda persisit czyli utrwal zapisuje za pomoca entity manager obiekt w H2
    }

    public Optional<Bike> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Bike.class, id));
    }
    @Transactional
    public void deleteById (Long id){
        findById(id).ifPresent(entityManager::remove);
    }
}
