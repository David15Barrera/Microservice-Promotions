package com.service.promotionService.promotions.infrastructure.outputadapter.feign;

import com.service.promotionService.promotions.infrastructure.inputadapter.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.RoomResponse;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.UUID;

public class HotelFeignClientFallbackFactory implements FallbackFactory<HotelFeignClient> {

    @Override
    public HotelFeignClient create(Throwable cause) {
        return new HotelFeignClient() {
            @Override
            public HotelResponse getHotelById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                HotelResponse fallbackResponse = new HotelResponse();
                fallbackResponse.id = id;
                fallbackResponse.name = "Servicio de Hoteles no disponible";
                fallbackResponse.totalRooms = 0;
                return fallbackResponse;
            }

            @Override
            public RoomResponse getRoomById(UUID id) {
                if (cause instanceof RetryableException) {
                    System.err.println("Network error: " + cause.getMessage());
                } else {
                    System.err.println("Other error: " + cause.getMessage());
                }

                RoomResponse fallbackResponse = new RoomResponse();
                fallbackResponse.id = id;
                fallbackResponse.roomNumber = "No disponible";
                fallbackResponse.description = "Servicio de Rooms no disponible";
                return fallbackResponse;
            }
        };
    }
}
