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
            return cafeMapper.getAll();
        }
    }

    public Cafe findById(int id) {
        return cafeMapper.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("こちらの情報は存在しません"));
    }

}
