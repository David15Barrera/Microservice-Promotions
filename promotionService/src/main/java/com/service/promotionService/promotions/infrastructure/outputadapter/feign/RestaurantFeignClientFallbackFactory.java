package com.service.promotionService.promotions.infrastructure.outputadapter.feign;

import com.service.promotionService.promotions.infrastructure.inputadapter.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.RestaurantResponse;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class RestaurantFeignClientFallbackFactory implements FallbackFactory<RestaurantFeignClient> {

    @Override
    public RestaurantFeignClient create(Throwable cause){
        return new RestaurantFeignClient() {
            @Override
            public RestaurantResponse getRestaurantById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                RestaurantResponse fallbackResponse = new RestaurantResponse();
                fallbackResponse.id = id;
                fallbackResponse.name = "Servicio de Hoteles no disponible";
                return fallbackResponse;
            }
        };
    }
}
