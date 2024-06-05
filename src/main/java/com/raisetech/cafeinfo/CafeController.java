package com.raisetech.cafeinfo;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CafeController {

    public CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("/cafes")
    public List<Cafe> findCafePlaces(@RequestParam(value = "place", required = false) String place) {
        return cafeService.findByPlaces(place);
    }

    @GetMapping("/cafes/{id}")
    public Cafe findInformation(@PathVariable("id") Integer id) {
        return cafeService.findById(id);
    }

    @PostMapping("/cafes")
    public ResponseEntity<CafeResponse> insert(@RequestBody @Valid CafeRequest cafeRequest, UriComponentsBuilder uriBuilder) {
        Cafe cafe = cafeService.insert(cafeRequest.getName(), cafeRequest.getPlace(), cafeRequest.getRegularHoliday(), cafeRequest.getOpeningHour(), cafeRequest.getNumberOfSeat(), cafeRequest.getBirthplace());
        URI location = uriBuilder.path("/cafes/{id}").buildAndExpand(cafe.getId()).toUri();
        CafeResponse body = new CafeResponse("カフェ情報が登録されました");
        return ResponseEntity.created(location).body(body);
    }

    @PatchMapping("/cafes/{id}")
    public ResponseEntity<CafeResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid CafeRequest cafeRequest) {
        Cafe updatedCafe = cafeService.update(id, cafeRequest);
        CafeResponse body = new CafeResponse("カフェ情報が更新されました");
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/cafes/{id}")
    public ResponseEntity<CafeResponse> delete(@PathVariable("id") Integer id) {
        cafeService.delete(id);
        CafeResponse body = new CafeResponse("カフェ情報が削除されました");
        return ResponseEntity.ok(body);
    }
}
