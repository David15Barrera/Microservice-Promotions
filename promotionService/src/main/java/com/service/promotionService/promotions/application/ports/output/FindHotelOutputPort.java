package com.service.promotionService.promotions.application.ports.output;

import com.service.promotionService.promotions.domain.model.HotelDomainEntity;

import java.util.UUID;

public interface FindHotelOutputPort {
    HotelDomainEntity findById(UUID id);
}
