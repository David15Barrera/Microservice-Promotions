package com.service.promotionService.promotions.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RoomDomainEntity {
    private UUID id;
    private UUID hotelId;
    private String roomNumber;
    private BigDecimal pricePerDay;
    private BigDecimal maintenanceCostPerDay;
    private String description;
    private Integer capacity;
    private String state;
}
