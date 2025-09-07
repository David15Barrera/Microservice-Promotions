package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.UUID;

public interface UpdatePromotionsInputPort {
    PromotionsDomainEntity update(UUID id, PromotionsDomainEntity promotions);
}
