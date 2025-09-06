package com.service.promotionService.promotions.application.usecase.create;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.CreatePromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.SavePromotionsOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

@UseCase
@Service
public class CreatepromotionsUseCase implements CreatePromotionsInputPort {

    private final SavePromotionsOutputPort savePort;

    public CreatepromotionsUseCase(SavePromotionsOutputPort savePort) {
        this.savePort = savePort;
    }


    @Override
    public PromotionsDomainEntity create(PromotionsDomainEntity promotions) {
        return savePort.save(promotions);
    }
}
