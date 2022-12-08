package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private LocalDate dateCreated;
    @ManyToMany
    private List<Order> orders;

    public ShoppingCart(User user, LocalDate dateCreated, List<Order> orders) {
        this.user = user;
        this.dateCreated = dateCreated;
        this.orders = orders;
    }

    public ShoppingCart() {}
}
