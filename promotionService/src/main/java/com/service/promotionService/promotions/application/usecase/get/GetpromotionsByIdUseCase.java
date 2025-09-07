package com.service.promotionService.promotions.application.usecase.get;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.GetPromotionsByIdInputPort;
import com.service.promotionService.promotions.application.ports.output.FindHotelOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindPromotionsByIdOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRestaurantOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRoomOutPort;
import com.service.promotionService.promotions.domain.model.HotelDomainEntity;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.domain.model.RestaurantDomainEntity;
import com.service.promotionService.promotions.domain.model.RoomDomainEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@UseCase
@Service
public class GetpromotionsByIdUseCase implements GetPromotionsByIdInputPort {
    private final FindPromotionsByIdOutputPort findByIdPort;
    private final FindHotelOutputPort HotelOutputPort;
    private final FindRoomOutPort findRoomOutPort;
    private final FindRestaurantOutputPort findRestaurantOutputPort;

    public GetpromotionsByIdUseCase(FindPromotionsByIdOutputPort findByIdPort,
                                    FindHotelOutputPort HotelOutputPort, FindRoomOutPort findRoomOutPort,
                                    FindRestaurantOutputPort findRestaurantOutputPort) {
        this.findByIdPort = findByIdPort;
        this.HotelOutputPort = HotelOutputPort;
        this.findRoomOutPort = findRoomOutPort;
        this.findRestaurantOutputPort = findRestaurantOutputPort;
    }

    @Override
    public PromotionsDomainEntity getById(UUID id) {
        PromotionsDomainEntity promotion = findByIdPort.findById(id)
                .orElseThrow(() -> new RuntimeException("promotion not found with id: " + id));

        if (promotion.getHotelId() != null) {
            HotelDomainEntity hotel = HotelOutputPort.findById(promotion.getHotelId());
            promotion.setHotel(hotel);
        }

        if (promotion.getRoomId() != null) {
            RoomDomainEntity room = findRoomOutPort.findById(promotion.getRoomId());
            promotion.setRoom(room);
        }

        if( promotion.getRestaurantId() != null){
            RestaurantDomainEntity restaurant = findRestaurantOutputPort.findById(promotion.getRestaurantId());
            promotion.setRestaurant(restaurant);
        }

        return promotion;
    }
}
