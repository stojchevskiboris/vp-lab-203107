package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class OrderRepository {
    List<Order> orders = new ArrayList<>(5);
    Order pedingOrder;

    public OrderRepository() {
        orders.add(new Order("Blue", "Big", "One", "Two"));
        orders.add(new Order("Blue", "Big", "One", "Two"));
        orders.add(new Order("Blue", "Big", "One", "Two"));
        orders.add(new Order("Blue", "Big", "One", "Two"));
        orders.add(new Order("Blue", "Big", "One", "Two"));
    }

    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(Long id) {
        return orders.stream().filter(r -> r.getOrderId() == (id)).findFirst();
    }

    public Optional<Order> save(String color, String size, String clientName, String clientAddress) {
        Order order = new Order(color, size, clientName, clientAddress);
        orders.removeIf(r -> r.getBalloonColor().equals(color));
        orders.add(order);
        return Optional.of(order);
    }

    public Order addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        Order order = new Order(balloonColor, balloonSize, clientName, clientAddress);
        pedingOrder = order;
        return order;
    }

    public void removePendingOrder() {
        pedingOrder = null;
    }

    public Order getPendingOrder() {
        return pedingOrder;
    }


}
