package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.List;

public interface FindingAllPromotionsOutputPort {
    List<PromotionsDomainEntity> findAll();
}
