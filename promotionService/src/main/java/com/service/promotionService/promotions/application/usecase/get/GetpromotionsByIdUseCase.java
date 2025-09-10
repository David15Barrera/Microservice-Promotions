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

    public GetpromotionsByIdUseCase(FindPromotionsByIdOutputPort findByIdPort) {
        this.findByIdPort = findByIdPort;
    }

    @Override
    public PromotionsDomainEntity getById(UUID id) {
        PromotionsDomainEntity promotion = findByIdPort.findById(id)
                .orElseThrow(() -> new RuntimeException("promotion not found with id: " + id));
        return promotion;
    }
}
