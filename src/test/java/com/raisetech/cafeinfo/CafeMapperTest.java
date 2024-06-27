package com.raisetech.cafeinfo;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CafeMapperTest {

    @Autowired
    CafeMapper cafeMapper;

    @Test
    @DataSet(value = "datasets/cafes.yml")
    @Transactional
    void カフェ情報が全件取得できていること() {
        List<Cafe> cafes = cafeMapper.findAll();
        assertThat(cafes)
                .hasSize(7)
                .contains(
                        new Cafe(1, "Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル"),
                        new Cafe(2, "nadoya no katte", "代々木上原", "月、火、水、木", "9時-18時", 15, "代々木上原"),
                        new Cafe(3, "Streamer Coffee Company", "原宿", "年中無休", "8時-20時", 56, "原宿"),
                        new Cafe(4, "ブルーボトルコーヒー清澄白河フラッグシップカフェ", "清澄白河", "年中無休", "8時-19時", 47, "カリフォルニア"),
                        new Cafe(5, "ARC", "蔵前", "年中無休", "平日10時-23時 休日8時半-23時", 52, "蔵前"),
                        new Cafe(6, "T.Y.HARBOR", "天王洲アイル", "年中無休", "11時半-22時", 350, "天王洲アイル"),
                        new Cafe(7, "No.13 Cafe", "新宿", "日", "11時-16時半", 30, "新宿")
                );
    }

    @Test
    @DataSet(value = "datasets/cafes.yml")
    @Transactional
    void 指定したIDのカフェ情報を取得できること() {
        Optional<Cafe> actual = cafeMapper.findById(1);
        assertThat(actual).hasValue(new Cafe(1, "Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル"));
    }

    @Test
    @DataSet(value = "datasets/cafes.yml")
    @Transactional
    void 存在しないIDを指定した場合に空のOptionalが返ること() {
        Optional<Cafe> actual = cafeMapper.findById(0);
        assertThat(actual).isEmpty();
    }

    @Test
    @DataSet(value = "datasets/cafes.yml")
    @Transactional
    void カフェ情報が登録できること() {
        Cafe newCafe = new Cafe("New Name", "New Place", "New RegularHoliday", "New OpeningHour", 1, "New Birthplace");
        cafeMapper.insertCafe(newCafe);
        assertThat(newCafe.getId()).isNotNull().isGreaterThan(0);

        List<Cafe> cafes = cafeMapper.findAll();
        assertThat(cafes).hasSize(8);
    }

    @Test
    @DataSet(value = "datasets/cafes.yml", cleanAfter = true)
    @Transactional
    void カフェ情報が更新されていること() {
        Cafe cafeToUpdate = new Cafe(1, "Updated Cafe", "Updated Place", "Updated RegularHoliday", "Updated OpeningHour", 1, "Updated Birthplace");
        cafeMapper.updateCafe(cafeToUpdate);

        Optional<Cafe> updatedCafe = cafeMapper.findById(1);
        assertThat(updatedCafe).isPresent();
        assertThat(updatedCafe.get()).isEqualTo(cafeToUpdate);
    }

    @Test
    @DataSet(value = "datasets/cafes.yml", cleanAfter = true)
    @Transactional
    void カフェ情報が削除されていること() {
        Integer cafeIdToDelete = 1;
        cafeMapper.deleteCafe(cafeIdToDelete);

        Optional<Cafe> deletedCafe = cafeMapper.findById(cafeIdToDelete);
        assertThat(deletedCafe).isEmpty();
    }
}
