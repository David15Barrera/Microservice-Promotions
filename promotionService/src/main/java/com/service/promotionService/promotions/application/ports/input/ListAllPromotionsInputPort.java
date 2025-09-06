package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.List;

public interface ListAllPromotionsInputPort {
    List<PromotionsDomainEntity> listAll();
}
