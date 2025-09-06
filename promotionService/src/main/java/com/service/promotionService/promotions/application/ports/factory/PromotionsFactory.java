package com.service.promotionService.promotions.application.ports.factory;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

public class PromotionsFactory {
    public static PromotionsDomainEntity create(String name) {
        return PromotionsDomainEntity.builder().name(name).build();
    }
}
