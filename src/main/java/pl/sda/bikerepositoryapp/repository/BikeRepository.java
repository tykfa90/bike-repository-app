package pl.sda.bikerepositoryapp.repository;

import org.springframework.stereotype.Repository;
import pl.sda.bikerepositoryapp.model.Bike;
import pl.sda.bikerepositoryapp.model.BikeType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BikeRepository {

    private Map<Integer, Bike> bikes;

    public BikeRepository() {
        Bike bike1 = new Bike();
        bike1.setId(1);
        bike1.setName("Boulder");
        bike1.setGears(18);
        bike1.setType(BikeType.MTB);

        Bike bike2 = new Bike();
        bike2.setId(2);
        bike2.setName("Shockforce");
        bike2.setGears(1);
        bike2.setType(BikeType.BMX);

        Bike bike3 = new Bike();
        bike3.setId(3);
        bike3.setName("Roadster");
        bike3.setGears(24);
        bike3.setType(BikeType.ROAD);

        Bike bike4 = new Bike();
        bike4.setId(4);
        bike4.setName("Atlanta XLS");
        bike4.setGears(18);
        bike4.setType(BikeType.CROSS);

        Bike bike5 = new Bike();
        bike5.setId(5);
        bike5.setName("Citizen 250");
        bike5.setGears(18);
        bike5.setType(BikeType.CITY);

        bikes = new HashMap<>();
        bikes.put(1, bike1);
        bikes.put(2, bike2);
        bikes.put(3, bike3);
        bikes.put(4, bike4);
        bikes.put(5, bike5);
    }

    public Collection<Bike> getBikes() {
        return bikes.values();
    }

    public Optional<Bike> findBike(int index) {
        return Optional.ofNullable(bikes.get(index));
    }

    public void storeBike(Bike bike) {
        bikes.put(bikes.keySet().size() + 1, bike);
    }

    public Bike deleteBike(int index) {
        return bikes.remove(index);
    }
}
