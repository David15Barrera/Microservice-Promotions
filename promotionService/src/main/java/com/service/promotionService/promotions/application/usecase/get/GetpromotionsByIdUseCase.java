package com.service.promotionService.promotions.application.usecase.get;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.GetPromotionsByIdInputPort;
import com.service.promotionService.promotions.application.ports.output.FindPromotionsByIdOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@UseCase
@Service
public class GetpromotionsByIdUseCase implements GetPromotionsByIdInputPort {
    private final FindPromotionsByIdOutputPort findByIdPort;

    public GetpromotionsByIdUseCase(FindPromotionsByIdOutputPort findByIdPort) {
        this.findByIdPort = findByIdPort;
    }

    @Override
    public PromotionsDomainEntity getById(Integer id) {
        Optional<PromotionsDomainEntity> opt = findByIdPort.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("Promotion not found"));
    }
}
