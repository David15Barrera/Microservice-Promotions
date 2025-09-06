package com.service.promotionService.promotions.application.usecase.delete;

import com.service.promotionService.common.annotations.UseCase;
import com.service.promotionService.promotions.application.ports.input.DeletePromotionsInputPort;
import com.service.promotionService.promotions.application.ports.output.DeletePromotionsOutputPort;
import org.springframework.stereotype.Service;

@UseCase
@Service
public class DeletepromotionsUseCase implements DeletePromotionsInputPort {
    private final DeletePromotionsOutputPort deletePort;

    public DeletepromotionsUseCase(DeletePromotionsOutputPort deletePort) {
        this.deletePort = deletePort;
    }

    @Override
    public void delete(Integer id) {
        deletePort.delete(id);
    }
}
