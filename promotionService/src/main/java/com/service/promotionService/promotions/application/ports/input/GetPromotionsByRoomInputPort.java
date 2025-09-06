package com.service.promotionService.promotions.application.ports.input;

import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;

import java.util.List;
import java.util.UUID;

public interface GetPromotionsByRoomInputPort {
    List<PromotionsDomainEntity> getPromotionsByRoom(UUID roomId);
}
