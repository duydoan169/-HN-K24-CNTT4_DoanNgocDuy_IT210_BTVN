package org.example.session05.bai5;

public class DishModel {
    private Long id;
    private String name;
    private Double price;
    private boolean isAvailable;

    public DishModel() {
    }

    public DishModel(Long id, String name, Double price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
