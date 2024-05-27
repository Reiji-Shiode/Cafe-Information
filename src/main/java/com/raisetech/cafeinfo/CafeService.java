package com.raisetech.cafeinfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeService {

    public CafeMapper cafeMapper;

    public CafeService(CafeMapper cafeMapper) {
        this.cafeMapper = cafeMapper;
    }

    List<Cafe> findAll() {
        return cafeMapper.getAll();
    }

    public List<Cafe> findByPlaces(String place) {
        return cafeMapper.findByPlaceWith(place);
    }

    public Cafe findId(int id) {
        return cafeMapper.findById(id)
                .orElseThrow(() -> new InformationNotFoundException("こちらの情報は存在しません"));
    }

}
