package com.raisetech.cafeinfo;

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
}
