package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.RoomDomainEntity;

import java.util.UUID;

public interface FindRoomOutPort {
    RoomDomainEntity findById(UUID id);
}
