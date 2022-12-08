package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "balloon_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;
    String balloonColor;
    String balloonSize;
    @ManyToOne
    User user;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.orderId = (long) (Math.random() * 1000);
    }

    public Order(){}

    public String getBalloonColor() {
        return balloonColor;
    }
    public String getBalloonSize() {
        return balloonSize;
    }
    public String getClientName() {
        return this.user.getUsername();
    }
    public Long getOrderId() {
        return orderId;
    }
}
