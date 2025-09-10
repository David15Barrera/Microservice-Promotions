package com.service.promotionService.promotions.application.usecase.listhotels;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.ListAllPromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.FindHotelOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRestaurantOutputPort;
import com.service.promotionService.promotions.application.ports.output.FindRoomOutPort;
import com.service.promotionService.promotions.application.ports.output.FindingAllPromotionsOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
public class ListAllpromotionsUseCase implements ListAllPromotionsInputPort {
    private final FindingAllPromotionsOutputPort findingAllPort;

    public ListAllpromotionsUseCase(FindingAllPromotionsOutputPort findingAllPort
                                    ) {
        this.findingAllPort = findingAllPort;
    }

    @Override
    public List<PromotionsDomainEntity> listAll() {
        List<PromotionsDomainEntity> promotions = findingAllPort.findAll();

        return promotions;
    }
}
