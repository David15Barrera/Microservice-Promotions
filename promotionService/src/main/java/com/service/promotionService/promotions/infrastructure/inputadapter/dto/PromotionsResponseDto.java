package com.service.promotionService.promotions.infrastructure.inputadapter.dto;

import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RestaurantResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RoomResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionsResponseDto {
    public UUID id;
    public String name;
    public String description;
    public String type;
    public BigDecimal discountPercentage;
    public LocalDate startDate;
    public LocalDate endDate;
    public UUID hotelId;
    public UUID restaurantId;
    public UUID customerId;
    public UUID roomId;
    public UUID dishId;

    public HotelResponse hotel;
    public RoomResponse room;
    public RestaurantResponse restaurant;
}
