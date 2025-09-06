package com.service.promotionService.promotions.application.usecase.get;


import com.service.promotionService.promotions.application.ports.input.GetPromotionsByRoomInputPort;
import com.service.promotionService.promotions.application.ports.output.FindPromotionsByRoomOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetpromotionsByIdRoomUseCase implements GetPromotionsByRoomInputPort {

    private final FindPromotionsByRoomOutputPort findPromotionsByRoomOutputPort;

    @Override
    public List<PromotionsDomainEntity> getPromotionsByRoom(UUID roomId){ // 'B' en mayúscula
        return findPromotionsByRoomOutputPort.getPromotionsByRoom(roomId);
    }
}