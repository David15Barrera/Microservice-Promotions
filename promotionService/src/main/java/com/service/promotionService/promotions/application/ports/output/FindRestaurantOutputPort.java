package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.RestaurantDomainEntity;

import java.util.UUID;

public interface FindRestaurantOutputPort {
    RestaurantDomainEntity findById(UUID id);
}
