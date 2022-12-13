package bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }
    @Transactional
    public void add(NewBikeDto newBike) {
        Bike bike = new Bike(newBike.getId(),
                newBike.getModel(),
                newBike.getSerialNO(),
                newBike.getHourPrice(),
                newBike.getDayPrice());
        bikeRepository.save(bike);
    }
    @Transactional
    public void deleteById(Long bikeId){
        bikeRepository.deleteById(bikeId);
    }
    @Transactional
    public double rentForHours(Long bikeId, int hours, String borrowerId){
        LocalDateTime dataOfReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(bikeId, borrowerId, dataOfReturn);
        return bike.getHourPrice() * hours;
    }
    @Transactional
    public double rentForDay(Long bikeId, String borrowerId){
        LocalDateTime dataOfReturn = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        Bike bike = updateBike(bikeId, borrowerId, dataOfReturn);
        return bike.getDayPrice();
    }
    @Transactional
    public void returnBike(Long bikeId){
        updateBike(bikeId,null,null);
    }

    private Bike updateBike(Long bikeId, String borrowerId, LocalDateTime dataOfReturn) {  // aktualizajca w baze danych
        Bike bike = bikeRepository.findById(bikeId)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDataOfReturn(dataOfReturn);
        bike.setBorrowedId(borrowerId);
        return bike;
    }


}
