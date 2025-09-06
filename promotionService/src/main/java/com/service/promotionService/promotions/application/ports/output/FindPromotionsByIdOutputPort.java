package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.Optional;

public interface FindPromotionsByIdOutputPort {
    Optional<PromotionsDomainEntity> findById(Integer id);
}
