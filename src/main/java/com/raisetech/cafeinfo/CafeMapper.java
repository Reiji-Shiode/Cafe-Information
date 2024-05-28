package com.raisetech.cafeinfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CafeMapper {

    @Select("SELECT * FROM cafes")
    List<Cafe> findAll();

    @Select("SELECT * FROM cafes WHERE place LIKE CONCAT (#{place}, '%')")
    List<Cafe> findByPlaceWith(String place);

    @Select("SELECT * FROM cafes WHERE id =#{id}")
    Optional<Cafe> findById(int id);
}
