package com.service.promotionService.promotions.application.usecase.update;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.UpdatePromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.UpdatePromotionsOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

@UseCase
@Service
public class UpdatepromotionsUseCase implements UpdatePromotionsInputPort {
    private final UpdatePromotionsOutputPort updatePort;

    public UpdatepromotionsUseCase(UpdatePromotionsOutputPort updatePort) {
        this.updatePort = updatePort;
    }

    @Override
    public PromotionsDomainEntity update(Integer id, PromotionsDomainEntity promotions) {
        return updatePort.update(id, promotions);
    }
}
