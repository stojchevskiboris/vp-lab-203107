package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Manufacturer {
    private long id;
    private String name;
    private String country;
    private String address;

    public Manufacturer(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.id = (long) (Math.random() * 1000);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
