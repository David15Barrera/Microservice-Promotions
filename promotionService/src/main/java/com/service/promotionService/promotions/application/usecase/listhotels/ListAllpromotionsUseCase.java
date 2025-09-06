package com.service.promotionService.promotions.application.usecase.listhotels;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.ListAllPromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.FindingAllPromotionsOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
public class ListAllpromotionsUseCase implements ListAllPromotionsInputPort {
    private final FindingAllPromotionsOutputPort findingAllPort;

    public ListAllpromotionsUseCase(FindingAllPromotionsOutputPort findingAllPort) {
        this.findingAllPort = findingAllPort;
    }

    @Override
    public List<PromotionsDomainEntity> listAll() {
        return findingAllPort.findAll();
    }
}
