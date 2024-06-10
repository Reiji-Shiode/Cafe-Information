package com.raisetech.cafeinfo;

import java.util.Objects;

public class Cafe {

    private Integer id;
    private String name;
    private String place;
    private String regularHoliday;
    private String openingHour;
    private int numberOfSeat;
    private String birthplace;

    public Cafe(Integer id, String name, String place, String regularHoliday, String openingHour, int numberOfSeat, String birthplace) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.regularHoliday = regularHoliday;
        this.openingHour = openingHour;
        this.numberOfSeat = numberOfSeat;
        this.birthplace = birthplace;
    }

    public Cafe(String name, String place, String regularHoliday, String openingHour, int numberOfSeat, String birthplace) {
        this.name = name;
        this.place = place;
        this.regularHoliday = regularHoliday;
        this.openingHour = openingHour;
        this.numberOfSeat = numberOfSeat;
        this.birthplace = birthplace;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getRegularHoliday() {
        return regularHoliday;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setRegularHoliday(String regularHoliday) {
        this.regularHoliday = regularHoliday;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return id == cafe.id && Objects.equals(name, cafe.name) && Objects.equals(place, cafe.place) && Objects.equals(regularHoliday, cafe.regularHoliday) && Objects.equals(openingHour, cafe.openingHour) && Objects.equals(numberOfSeat, cafe.numberOfSeat) && Objects.equals(birthplace, cafe.birthplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, place, regularHoliday, openingHour, numberOfSeat, birthplace);
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"place\":" + place + "\"regularHoliday\":" + regularHoliday + "\"openingHour\":" + openingHour + "\"numberOfSeat\":" + numberOfSeat + "\"birthplace\":" + birthplace + "\"}";
    }
}
