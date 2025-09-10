package com.service.promotionService.promotions.infrastructure.outputadapter.factory;

import com.service.promotionService.promotions.application.ports.output.FindHotelOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRestaurantOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRoomOutPort;
import com.service.promotionService.promotions.domain.model.HotelDomainEntity;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.domain.model.RestaurantDomainEntity;
import com.service.promotionService.promotions.domain.model.RoomDomainEntity;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.HotelResponse;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.PromotionsResponseDto;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RestaurantResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RoomResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionsWithRelationsFactory {

    private final FindHotelOutputPort hotelOutputPort;
    private final FindRoomOutPort roomOutputPort;
    private final FindRestaurantOutputPort restaurantOutputPort;

    public PromotionsWithRelationsFactory(
            FindHotelOutputPort hotelOutputPort,
            FindRoomOutPort roomOutputPort,
            FindRestaurantOutputPort restaurantOutputPort) {
        this.hotelOutputPort = hotelOutputPort;
        this.roomOutputPort = roomOutputPort;
        this.restaurantOutputPort = restaurantOutputPort;
    }

    public PromotionsResponseDto fromDomain(PromotionsDomainEntity domain) {
        if (domain == null) return null;

        PromotionsResponseDto dto = new PromotionsResponseDto();
        dto.id = domain.getId();
        dto.name = domain.getName();
        dto.description = domain.getDescription();
        dto.type = domain.getType();
        dto.discountPercentage = domain.getDiscountPercentage();
        dto.startDate = domain.getStartDate();
        dto.endDate = domain.getEndDate();
        dto.hotelId = domain.getHotelId();
        dto.restaurantId = domain.getRestaurantId();
        dto.customerId = domain.getCustomerId();
        dto.roomId = domain.getRoomId();
        dto.dishId = domain.getDishId();

        // Hotel
        if (domain.getHotelId() != null) {
            try {
                HotelDomainEntity hotel = hotelOutputPort.findById(domain.getHotelId());
                HotelResponse hotelResponse = new HotelResponse();
                hotelResponse.id = hotel.getId();
                hotelResponse.name = hotel.getName();
                hotelResponse.address = hotel.getAddress();
                hotelResponse.phone = hotel.getPhone();
                hotelResponse.totalRooms = hotel.getTotalRooms();
                dto.hotel = hotelResponse;
            } catch (Exception e) {
                dto.hotel = null;
            }
        }

        // Room
        if (domain.getRoomId() != null) {
            try {
                RoomDomainEntity room = roomOutputPort.findById(domain.getRoomId());
                RoomResponse roomResponse = new RoomResponse();
                roomResponse.id = room.getId();
                roomResponse.hotelId = room.getHotelId();
                roomResponse.roomNumber = room.getRoomNumber();
                roomResponse.pricePerDay = room.getPricePerDay();
                roomResponse.maintenanceCostPerDay = room.getMaintenanceCostPerDay();
                roomResponse.description = room.getDescription();
                roomResponse.capacity = room.getCapacity();
                roomResponse.state = room.getState();
                dto.room = roomResponse;
            } catch (Exception e) {
                dto.room = null;
            }
        }

        // Restaurant
        if (domain.getRestaurantId() != null) {
            try {
                RestaurantDomainEntity restaurant = restaurantOutputPort.findById(domain.getRestaurantId());
                RestaurantResponse restaurantResponse = new RestaurantResponse();
                restaurantResponse.id = restaurant.getId();
                restaurantResponse.name = restaurant.getName();
                restaurantResponse.hotelId = restaurant.getHotelId();
                restaurantResponse.address = restaurant.getAddress();
                restaurantResponse.phone = restaurant.getPhone();
                restaurantResponse.capacity = restaurant.getCapacity();
                restaurantResponse.openingTime = restaurant.getOpeningTime();
                restaurantResponse.closingTime = restaurant.getClosingTime();
                restaurantResponse.createdAt = restaurant.getCreatedAt();
                dto.restaurant = restaurantResponse;
            } catch (Exception e) {
                dto.restaurant = null;
            }
        }

        return dto;
    }

    public List<PromotionsResponseDto> fromDomainList(List<PromotionsDomainEntity> list) {
        return list.stream().map(this::fromDomain).toList();
    }
}
