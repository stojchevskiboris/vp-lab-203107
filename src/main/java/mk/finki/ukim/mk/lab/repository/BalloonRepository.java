package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BalloonRepository {
    private List<Balloon> balloons = new ArrayList<>(10);
    public BalloonRepository(){
        this.balloons.add(new Balloon("Blue","Small"));
        this.balloons.add(new Balloon("Blue","Medium"));
        this.balloons.add(new Balloon("Blue","Big"));
        this.balloons.add(new Balloon("Red","Small"));
        this.balloons.add(new Balloon("Red","Medium"));
        this.balloons.add(new Balloon("Red","Extra Big"));
        this.balloons.add(new Balloon("Green","Small"));
        this.balloons.add(new Balloon("Green","Medium"));
        this.balloons.add(new Balloon("Green","Big"));
        this.balloons.add(new Balloon("Yellow","Extra Big"));
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
}
