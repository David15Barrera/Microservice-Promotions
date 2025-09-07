package com.service.promotionService.promotions.application.ports.output;

import java.util.UUID;

public interface DeletePromotionsOutputPort {
    void delete(UUID id);
}
