package com.service.promotionService.promotions.infrastructure.inputadapter.mapper;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.*;

public class PromotionsMapperRest {
    public static PromotionsDomainEntity toDomain(PromotionsRequestDto dto){
        return PromotionsDomainEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .type(dto.getType())
                .discountPercentage(dto.getDiscountPercentage())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .hotelId(dto.getHotelId())
                .restaurantId(dto.getRestaurantId())
                .customerId(dto.getCustomerId())
                .roomId(dto.getRoomId())
                .dishId(dto.getDishId())
                .build();
    }

    public static PromotionsResponseDto toResponse(PromotionsDomainEntity domain){
        return PromotionsResponseDto.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .type(domain.getType())
                .discountPercentage(domain.getDiscountPercentage())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .hotelId(domain.getHotelId())
                .restaurantId(domain.getRestaurantId())
                .customerId(domain.getCustomerId())
                .roomId(domain.getRoomId())
                .dishId(domain.getDishId())
                .build();
    }
}
