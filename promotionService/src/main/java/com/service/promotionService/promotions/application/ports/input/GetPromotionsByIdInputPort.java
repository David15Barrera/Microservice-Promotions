package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.UUID;

public interface GetPromotionsByIdInputPort {
    PromotionsDomainEntity getById(UUID id);
}
