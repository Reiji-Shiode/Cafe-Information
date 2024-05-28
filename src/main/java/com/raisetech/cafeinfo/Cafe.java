package com.raisetech.cafeinfo;

public class Cafe {

    private int id;
    private String name;
    private String place;
    private String regularHoriday;
    private String openingHour;
    private int numberOfSeat;
    private String birthplace;

    public Cafe(int id, String name, String place, String regularHoriday, String openingHour, int numberOfSeat, String birthplace) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.regularHoriday = regularHoriday;
        this.openingHour = openingHour;
        this.numberOfSeat = numberOfSeat;
        this.birthplace = birthplace;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getRegularHoriday() {
        return regularHoriday;
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
}
