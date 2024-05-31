package com.raisetech.cafeinfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Cafe findInformation(@PathVariable("id") int id) {
        return cafeService.findById(id);
    }

    @PostMapping("/cafes")
    public ResponseEntity<CafeResponse> insert(@RequestBody CafeRequest cafeRequest, UriComponentsBuilder uriBuilder) {
        Cafe cafe = cafeService.insert(cafeRequest.getName(), cafeRequest.getPlace(), cafeRequest.getRegularHoliday(), cafeRequest.getOpeningHour(), cafeRequest.getNumberOfSeat(), cafeRequest.getBirthplace());
        URI location = uriBuilder.path("/cafes/{id}").buildAndExpand(cafe.getId()).toUri();
        CafeResponse body = new CafeResponse("カフェ情報が登録されました");
        return ResponseEntity.created(location).body(body);
    }

    @PatchMapping("/cafes/{id}")
    public ResponseEntity<CafeResponse> update(@PathVariable("id") int id, @RequestBody CafeRequest cafeRequest) {
        Cafe updatedCafe = cafeService.update(id, cafeRequest);
        CafeResponse body = new CafeResponse("カフェ情報が更新されました");
        return ResponseEntity.ok(body);
    }
}
