package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

public interface SavePromotionsOutputPort {
    PromotionsDomainEntity save(PromotionsDomainEntity promotions);
}
