package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public static List<User> users = new ArrayList<>();


    public List<User> listAll() {
        return users;
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(r -> r.getName().equals(name)).findFirst();
    }

    public Optional<User> save(String name) {
        User user = new User(name);
        users.add(user);
        return Optional.of(user);
    }
}
