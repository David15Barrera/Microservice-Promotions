package com.service.promotionService.promotions.application.usecase.getbyRestaurant;

import com.service.promotionService.promotions.application.ports.input.GetPromotionsByRestaurantInputPort;
import com.service.promotionService.promotions.application.ports.output.FindPromotionsByRestaurantOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPromotionsByRestaurantUseCase implements GetPromotionsByRestaurantInputPort {

    private final FindPromotionsByRestaurantOutputPort findPromotionsByRestaurantOutputPort;

    @Override
    public List<PromotionsDomainEntity> getPromotionsByRestaurant(UUID restaurantId) {
        return findPromotionsByRestaurantOutputPort.findByRestaurantId(restaurantId);
    }
}