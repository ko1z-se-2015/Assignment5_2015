package entities;

import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private LocalDate expiration_date;
    private String manufacturer;
    private int number;

    public Medicine(){

    }
    public Medicine(int id, String name, double price, LocalDate expiration_date, String manufacturer,int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiration_date = expiration_date;
        this.manufacturer = manufacturer;
        this.number = number;
    }
    public Medicine(String name, double price, LocalDate expiration_date, String manufacturer,int number) {

        this.name = name;
        this.price = price;
        this.expiration_date = expiration_date;
        this.manufacturer = manufacturer;
        this.number = number;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expiration_date=" + expiration_date +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
