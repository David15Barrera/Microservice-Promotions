package com.service.promotionService.promotions.infrastructure.outputadapter.feign;

import com.service.promotionService.promotions.infrastructure.inputadapter.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.RoomResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "hotelClient", url = "http://localhost:8082/api/hotel", fallbackFactory = HotelFeignClientFallbackFactory.class)
public interface HotelFeignClient {
    @GetMapping("/api/v1/hotels/{id}")
    HotelResponse getHotelById(@PathVariable("id") UUID id);


    @GetMapping("/api/v1/rooms/{id}")
    RoomResponse getRoomById(@PathVariable("id") UUID id);

}
