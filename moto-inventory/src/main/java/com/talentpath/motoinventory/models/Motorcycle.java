package com.talentpath.motoinventory.models;

import java.util.Objects;

public class Motorcycle {
    private int id;
    private String vin;
    private String make;
    private String type;
    private String model;
    private String year;
    private String color;
    private Boolean sold;

    public Motorcycle() {
    }

    public Motorcycle(String vin, String make, String type, String model, String year, String color, Boolean sold) {
        this.vin = vin;
        this.make = make;
        this.type = type;
        this.model = model;
        this.year = year;
        this.color = color;
        this.sold = sold;
    }

    public Motorcycle(int id, String vin, String make, String type, String model, String year, String color, Boolean sold) {
        this.id = id;
        this.vin = vin;
        this.make = make;
        this.type = type;
        this.model = model;
        this.year = year;
        this.color = color;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return id == that.id && Objects.equals(vin, that.vin) && Objects.equals(make, that.make) && Objects.equals(type, that.type) && Objects.equals(model, that.model) && Objects.equals(year, that.year) && Objects.equals(color, that.color) && Objects.equals(sold, that.sold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, make, type, model, year, color, sold);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", sold=" + sold +
                '}';
    }
}
