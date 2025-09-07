package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.UUID;

public interface UpdatePromotionsOutputPort {
    PromotionsDomainEntity update(UUID id, PromotionsDomainEntity promotions);
}
