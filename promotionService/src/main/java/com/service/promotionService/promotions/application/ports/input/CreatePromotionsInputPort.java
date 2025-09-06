package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

public interface CreatePromotionsInputPort {
    PromotionsDomainEntity create(PromotionsDomainEntity promotions);
}
