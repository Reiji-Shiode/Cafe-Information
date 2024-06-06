package com.raisetech.cafeinfo;

//カフェ情報を登録、更新する際に使うリクエストパラメータ

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CafeRequest {

    @NotBlank(message = "名前は必須項目です")
    @Size(max = 100, message = "名前は100文字以内で入力してください")
    private String name;

    @NotBlank(message = "場所は必須項目です")
    @Size(max = 40, message = "場所は40文字以内で入力してください")
    private String place;

    @NotBlank(message = "定休日は必須項目です")
    @Size(max = 50, message = "定休日は50字以内で入力してください")
    private String regularHoliday;

    @NotBlank(message = "営業時間は必須項目です")
    @Size(max = 50, message = "営業時間は50文字以内で入力してください")
    private String openingHour;

    @NotNull(message = "座席数は必須項目です")
    @Positive(message = "座席数は正の整数でなければなりません")
    private int numberOfSeat;

    @NotBlank(message = "発祥地は必須項目です")
    @Size(max = 30, message = "発祥地は30文字以内で入力してください")
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
