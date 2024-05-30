package com.raisetech.cafeinfo;

//カフェ情報を登録する際に使うリクエストパラメータ

public class CafeRequest {

    private String name;
    private String place;
    private String regularHoliday;
    private String openingHour;
    private int numberOfSeat;
    private String birthplace;

    public CafeRequest(String name, String place, String regularHoliday, String openingHour, int numberOfSeat, String birthplace) {
        this.name = name;
        this.place = place;
        this.regularHoliday = regularHoliday;
        this.openingHour = openingHour;
        this.numberOfSeat = numberOfSeat;
        this.birthplace = birthplace;
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
