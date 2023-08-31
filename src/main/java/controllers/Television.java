package controllers;

public class Television {
    String name;
    String brand;
    int serialNumber;

    //this is constructor of Television Class
    public Television(String name, String brand, int serialNumber) {
        this.name = name;
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
