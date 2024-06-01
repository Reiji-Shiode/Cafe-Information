package com.raisetech.cafeinfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {

    public CafeMapper cafeMapper;

    public CafeService(CafeMapper cafeMapper) {
        this.cafeMapper = cafeMapper;
    }

    public List<Cafe> findByPlaces(String place) {
        if (place != null && !place.isEmpty()) {
            return cafeMapper.findByPlaceWith(place);
        } else {
            return cafeMapper.findAll();
        }
    }

    public Cafe findById(Integer id) {
        return cafeMapper.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("こちらの情報は存在しません"));
    }

    public Cafe insert(String name, String place, String regularHoliday, String openingHour, int numberOfSeat, String birthplace) {
        Cafe cafe = new Cafe(name, place, regularHoliday, openingHour, numberOfSeat, birthplace);
        cafeMapper.insertCafe(cafe);
        return cafe;
    }

    public Cafe update(Integer id, CafeRequest cafeRequest) {
        Cafe cafe = cafeMapper.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("カフェ情報が見つかりません"));

        cafe.setName(cafeRequest.getName());
        cafe.setPlace(cafeRequest.getPlace());
        cafe.setRegularHoliday(cafeRequest.getRegularHoliday());
        cafe.setOpeningHour(cafeRequest.getOpeningHour());
        cafe.setNumberOfSeat(cafeRequest.getNumberOfSeat());
        cafe.setBirthplace(cafeRequest.getBirthplace());

        cafeMapper.updateCafe(cafe);
        return cafe;
    }

    public void delete(Integer id) {
        Cafe cafe = cafeMapper.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("カフェ情報が見つかりません"));
        cafeMapper.deleteCafe(id);
    }

}
