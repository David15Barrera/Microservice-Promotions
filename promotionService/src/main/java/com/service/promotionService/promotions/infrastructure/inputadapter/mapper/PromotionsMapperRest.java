package com.service.promotionService.promotions.infrastructure.inputadapter.mapper;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.*;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RestaurantResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RoomResponse;

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

    public static PromotionsResponseDto toResponse(PromotionsDomainEntity domain) {
        PromotionsResponseDto.PromotionsResponseDtoBuilder builder = PromotionsResponseDto.builder()
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
                .dishId(domain.getDishId());

        if (domain.getHotel() != null) {
            HotelResponse hotelResponse = new HotelResponse();
            hotelResponse.id = domain.getHotel().getId();
            hotelResponse.name = domain.getHotel().getName();
            hotelResponse.address = domain.getHotel().getAddress();
            hotelResponse.phone = domain.getHotel().getPhone();
            hotelResponse.totalRooms = domain.getHotel().getTotalRooms();

            builder.hotel(hotelResponse);
        }
        if (domain.getRoom() != null) {
            RoomResponse roomResponse = new RoomResponse();
            roomResponse.id = domain.getRoom().getId();
            roomResponse.hotelId = domain.getRoom().getHotelId();
            roomResponse.roomNumber = domain.getRoom().getRoomNumber();
            roomResponse.pricePerDay = domain.getRoom().getPricePerDay();
            roomResponse.maintenanceCostPerDay = domain.getRoom().getMaintenanceCostPerDay();
            roomResponse.description = domain.getRoom().getDescription();
            roomResponse.capacity = domain.getRoom().getCapacity();
            roomResponse.state = domain.getRoom().getState();

            builder.room(roomResponse);
        }

        if( domain.getRestaurant() != null){
            RestaurantResponse restaurantResponse = new RestaurantResponse();
            restaurantResponse.id = domain.getRestaurant().getId();
            restaurantResponse.name = domain.getRestaurant().getName();
            restaurantResponse.hotelId = domain.getRestaurant().getHotelId();
            restaurantResponse.address = domain.getRestaurant().getAddress();
            restaurantResponse.phone = domain.getRestaurant().getPhone();
            restaurantResponse.capacity = domain.getRestaurant().getCapacity();
            restaurantResponse.openingTime = domain.getRestaurant().getOpeningTime();
            restaurantResponse.closingTime = domain.getRestaurant().getClosingTime();
            restaurantResponse.createdAt = domain.getRestaurant().getCreatedAt();

            builder.restaurant(restaurantResponse);

        }


        return builder.build();
    }
}