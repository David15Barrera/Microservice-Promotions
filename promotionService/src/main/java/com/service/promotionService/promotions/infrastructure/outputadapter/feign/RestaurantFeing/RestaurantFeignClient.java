package com.service.promotionService.promotions.infrastructure.outputadapter.feign.RestaurantFeing;

import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RestaurantResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.fallback.RestaurantFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "RestaurantClient", url = "http://localhost:8084/api/restaurant", fallbackFactory = RestaurantFeignClientFallbackFactory.class)
public interface RestaurantFeignClient {

    @GetMapping("/api/restaurants/{id}")
    RestaurantResponse getRestaurantById(@PathVariable("id") UUID id);

}
