package com.service.promotionService.promotions.application.usecase.getbyHotel;

import com.service.promotionService.promotions.application.ports.input.GetPromotionsByHotelInputPort;
import com.service.promotionService.promotions.application.ports.output.FindPromotionsByHotelOutputPort;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPromotionsByHotelUseCase implements GetPromotionsByHotelInputPort {

    private final FindPromotionsByHotelOutputPort findPromotionsByHotelOutputPort;

    @Override
    public List<PromotionsDomainEntity> getPromotionsByHotel(UUID hotelId) {
        return findPromotionsByHotelOutputPort.findByHotelId(hotelId);
    }
}

