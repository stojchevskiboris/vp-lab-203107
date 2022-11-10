package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository {
    List<Balloon> balloons = new ArrayList<>(10);
    public BalloonRepository(){
        this.balloons.add(new Balloon("Blue","Small",null));
        this.balloons.add(new Balloon("Blue","Medium",null));
        this.balloons.add(new Balloon("Blue","Big",null));
        this.balloons.add(new Balloon("Red","Small",null));
        this.balloons.add(new Balloon("Red","Medium",null));
        this.balloons.add(new Balloon("Red","Extra Big",null));
        this.balloons.add(new Balloon("Green","Small",null));
        this.balloons.add(new Balloon("Green","Medium",null));
        this.balloons.add(new Balloon("Green","Big",null));
        this.balloons.add(new Balloon("Yellow","Extra Big",null));
    }

    public List<Balloon> findAllBalloons(){
        return this.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        List<Balloon> foundBalloons = new ArrayList<>();
        for (Balloon balloon : balloons){
            if (balloon.getName().contains(text) || balloon.getDescription().contains(text))
                foundBalloons.add(balloon);
        }
        return foundBalloons;
    }

    public Optional<Balloon> findById(Long id) {
        return balloons
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer) {
        balloons.removeIf(r -> r.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer);
        balloons.add(balloon);
        return Optional.of(balloon);
    }

    public void delete(Long id) {
        balloons.removeIf(r -> r.getId().equals(id));
    }
}
