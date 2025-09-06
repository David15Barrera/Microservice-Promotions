package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

public interface UpdatePromotionsOutputPort {
    PromotionsDomainEntity update(Integer id, PromotionsDomainEntity promotions);
}
