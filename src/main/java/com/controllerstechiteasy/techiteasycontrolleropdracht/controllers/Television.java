package com.controllerstechiteasy.techiteasycontrolleropdracht.controllers;

public class Television {
    private String name;
    private String brand;
    private int serialNumber;


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

    @Override
    public String toString() {
        return "Television{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
