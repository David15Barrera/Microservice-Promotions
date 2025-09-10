package com.service.promotionService.promotions.infrastructure.outputadapter.feign;

import com.service.promotionService.promotions.application.ports.output.FindRoomOutPort;
import com.service.promotionService.promotions.domain.model.RoomDomainEntity;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RoomResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.HotelFeign.HotelFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoomFeignOutputAdapter implements FindRoomOutPort {

    private final HotelFeignClient client;

    public RoomFeignOutputAdapter(HotelFeignClient client) {
        this.client = client;
    }

    @Override
    public RoomDomainEntity findById(UUID id) {
        RoomResponse response = client.getRoomById(id);

        RoomDomainEntity domain = new RoomDomainEntity();
        domain.setId(response.id);
        domain.setHotelId(response.hotelId);
        domain.setRoomNumber(response.roomNumber);
        domain.setPricePerDay(response.pricePerDay);
        domain.setMaintenanceCostPerDay(response.pricePerDay);
        domain.setDescription(response.description);
        domain.setCapacity(response.capacity);
        domain.setState(response.state);

        return domain;
    }
}