package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.List;
import java.util.UUID;

public interface FindPromotionsByRoomOutputPort {
    List<PromotionsDomainEntity> getPromotionsByRoom(UUID roomId);
}
