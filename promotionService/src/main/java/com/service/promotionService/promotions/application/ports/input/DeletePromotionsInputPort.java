package com.service.promotionService.promotions.application.ports.input;

import java.util.UUID;

public interface DeletePromotionsInputPort {
    void delete(UUID id);
}
