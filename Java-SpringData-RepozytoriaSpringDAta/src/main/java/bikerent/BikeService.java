package bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Transactional
    public void add(BikeDto newBike) {
        Bike bike = new Bike(newBike.getId(),
                newBike.getModel(),
                newBike.getSerialNO(),
                newBike.getHourPrice(),
                newBike.getDayPrice());
        bikeRepository.save(bike);
    }

    @Transactional
    public void deleteById(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Transactional
    public double rentForHours(String serialNo, int hours, String borrowerId) {
        LocalDateTime dataOfReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(serialNo, borrowerId, dataOfReturn);
        return bike.getHourPrice() * hours;
    }

    @Transactional
    public double rentForDay(String serialNo, String borrowerId) {
        LocalDateTime dataOfReturn = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        Bike bike = updateBike(serialNo, borrowerId, dataOfReturn);
        return bike.getDayPrice();
    }

    @Transactional
    public void returnBike(String serialNo) {
        updateBike(serialNo, null, null);
    }

    private Bike updateBike(String serialNo, String borrowerId, LocalDateTime dataOfReturn) {  // aktualizajca w baze danych
        Bike bike = bikeRepository.findBySerialNoIgnoreCase(serialNo)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDataOfReturn(dataOfReturn);
        bike.setBorrowerId(borrowerId);
        return bike;
    }

    public int countBorrowedBikes() {
        return bikeRepository.countAllByBorrowerIdIsNotNull();
    }

    public List<BikeDto> findAllAvailableBikes() {
        return bikeRepository.findAllByBorrowerIdIsNullOrderByDayPrice()
                .stream()
                .map(bike -> new BikeDto(bike.getId(),
                        bike.getModel(),
                        bike.getSerialNO(),
                        bike.getHourPrice(),
                        bike.getDayPrice()))
                .collect(Collectors.toList());
    }



}
