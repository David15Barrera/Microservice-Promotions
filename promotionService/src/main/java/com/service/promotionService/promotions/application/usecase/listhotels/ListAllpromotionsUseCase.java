package com.service.promotionService.promotions.application.usecase.listhotels;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.ListAllPromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.FindHotelOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRestaurantOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRoomOutPort;
import com.service.promotionService.promotions.application.ports.output.FindingAllPromotionsOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
public class ListAllpromotionsUseCase implements ListAllPromotionsInputPort {
    private final FindingAllPromotionsOutputPort findingAllPort;
    private final FindHotelOutputPort HotelOutputPort;
    private final FindRoomOutPort findRoomOutPort;
    private final FindRestaurantOutputPort findRestaurantOutputPort;

    public ListAllpromotionsUseCase(FindingAllPromotionsOutputPort findingAllPort,
                                    FindHotelOutputPort HotelOutputPort,
                                    FindRoomOutPort findRoomOutPort,
                                    FindRestaurantOutputPort findRestaurantOutputPort) {
        this.findingAllPort = findingAllPort;
        this.HotelOutputPort = HotelOutputPort;
        this.findRoomOutPort = findRoomOutPort;
        this.findRestaurantOutputPort = findRestaurantOutputPort;
    }

    @Override
    public List<PromotionsDomainEntity> listAll() {
        List<PromotionsDomainEntity> promotions = findingAllPort.findAll();

        for (PromotionsDomainEntity promotion : promotions) {
            if (promotion.getHotelId() != null) {
                promotion.setHotel(HotelOutputPort.findById(promotion.getHotelId()));
            } else {
                promotion.setHotel(null);
            }

            if (promotion.getRoomId() != null) {
                promotion.setRoom(findRoomOutPort.findById(promotion.getRoomId()));
            } else {
                promotion.setRoom(null);
            }

            if (promotion.getRestaurantId() != null) {
                promotion.setRestaurant(findRestaurantOutputPort.findById(promotion.getRestaurantId()));
            } else {
                promotion.setRestaurant(null);
            }
        }


        return promotions;
    }
}
