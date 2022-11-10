package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    List<Manufacturer> manufacturers = new ArrayList<>(5);

    public ManufacturerRepository() {
        this.manufacturers.add(new Manufacturer("BIC", "France", "Paris, 12th"));
        this.manufacturers.add(new Manufacturer("Globe-RS", "China", "Wuhan, 92"));
        this.manufacturers.add(new Manufacturer("Pearl Hart", "USA", "LA, 24"));
        this.manufacturers.add(new Manufacturer("Orion", "USA", "Miami, 101"));
        this.manufacturers.add(new Manufacturer("TestersCo", "Canada", "Toronto, 10"));
    }

    public List<Manufacturer> findAll() {
        return this.manufacturers;
    }

    public Optional<Manufacturer> findById(Long id) {
        return manufacturers.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
