package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

public interface UpdatePromotionsInputPort {
    PromotionsDomainEntity update(Integer id, PromotionsDomainEntity promotions);
}
