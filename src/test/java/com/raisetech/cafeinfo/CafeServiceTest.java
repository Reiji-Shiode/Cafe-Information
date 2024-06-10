package com.raisetech.cafeinfo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CafeServiceTest {

    @InjectMocks
    private CafeService cafeService;

    @Mock
    private CafeMapper cafeMapper;

    @Test
    public void 存在するカフェ情報のIDを指定した時に正常にカフェ情報を取得できること() {
        Cafe cafe = new Cafe(1, "Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル");
        doReturn(Optional.of(cafe)).when(cafeMapper).findById(1);
        Cafe actual = cafeService.findById(1);
        assertThat(actual).isEqualTo(cafe);
    }

    @Test
    public void 全てのカフェ情報が取得できていること() {
        List<Cafe> cafes = List.of(
                new Cafe(1, "Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル"),
                new Cafe(2, "nadoya no katte", "代々木上原", "月、火、水、木", "9時-18時", 15, "代々木上原"),
                new Cafe(3, "Streamer Coffee Company", "原宿", "年中無休", "8時-20時", 56, "原宿"),
                new Cafe(4, "ブルーボトルコーヒー清澄白河フラッグシップカフェ", "清澄白河", "年中無休", "8時-19時", 47, "カリフォルニア"),
                new Cafe(5, "ARC", "蔵前", "年中無休", "平日10時-23時 休日8時半-23時", 52, "蔵前"),
                new Cafe(6, "T.Y.HARBOR", "天王洲アイル", "年中無休", "11時半-22時", 350, "天王洲アイル"),
                new Cafe(7, "No.13 Cafe", "新宿", "日", "11時-16時半", 30, "新宿")
        );
        doReturn(cafes).when(cafeMapper).findAll();
        List<Cafe> actual = cafeService.findByPlaces(null);
        assertThat(actual).isEqualTo(cafes);
        verify(cafeMapper).findAll();
    }

    @Test
    public void 空の場所文字列が渡された時に全てのカフェ情報が取得できること() {
        List<Cafe> cafes = List.of(
                new Cafe(1, "Starbucks Reserve Roastery", "中目黒", "年中無休", "7時-22時", 300, "シアトル"),
                new Cafe(2, "nadoya no katte", "代々木上原", "月、火、水、木", "9時-18時", 15, "代々木上原"),
                new Cafe(3, "Streamer Coffee Company", "原宿", "年中無休", "8時-20時", 56, "原宿"),
                new Cafe(4, "ブルーボトルコーヒー清澄白河フラッグシップカフェ", "清澄白河", "年中無休", "8時-19時", 47, "カリフォルニア"),
                new Cafe(5, "ARC", "蔵前", "年中無休", "平日10時-23時 休日8時半-23時", 52, "蔵前"),
                new Cafe(6, "T.Y.HARBOR", "天王洲アイル", "年中無休", "11時半-22時", 350, "天王洲アイル"),
                new Cafe(7, "No.13 Cafe", "新宿", "日", "11時-16時半", 30, "新宿")
        );
        doReturn(cafes).when(cafeMapper).findAll();
        List<Cafe> actual = cafeService.findByPlaces("");
        assertThat(actual).isEqualTo(cafes);
        verify(cafeMapper).findAll();
    }

    @Test
    public void 存在しないカフェ情報のIDを指定した時に例外スローされること() {
        doReturn(Optional.empty()).when(cafeMapper).findById(0);
        assertThatThrownBy(() -> {
            cafeService.findById(0);
        }).isInstanceOf(InformationNotFoundException.class)
                .hasMessage("こちらの情報は存在しません");
    }
}
