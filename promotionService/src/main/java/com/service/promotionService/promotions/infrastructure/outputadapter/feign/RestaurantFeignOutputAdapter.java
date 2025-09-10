package com.service.promotionService.promotions.infrastructure.outputadapter.feign;

import com.service.promotionService.promotions.application.ports.output.FindRestaurantOutputPort;
import com.service.promotionService.promotions.domain.model.RestaurantDomainEntity;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.dto.RestaurantResponse;
import com.service.promotionService.promotions.infrastructure.outputadapter.feign.RestaurantFeing.RestaurantFeignClient;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestaurantFeignOutputAdapter implements FindRestaurantOutputPort {

    private final RestaurantFeignClient client;

    public RestaurantFeignOutputAdapter(RestaurantFeignClient client){
        this.client = client;
    }

    @Override
    public RestaurantDomainEntity findById(UUID id){
        RestaurantResponse response = client.getRestaurantById(id);

        RestaurantDomainEntity domain = new RestaurantDomainEntity();
        domain.setId(response.id);
        domain.setName(response.name);
        domain.setHotelId(response.hotelId);
        domain.setAddress(response.address);
        domain.setPhone(response.phone);
        domain.setCapacity(response.capacity);
        domain.setOpeningTime(response.openingTime);
        domain.setClosingTime(response.closingTime);
        domain.setCreatedAt(response.createdAt);

        return domain;
    }
}
