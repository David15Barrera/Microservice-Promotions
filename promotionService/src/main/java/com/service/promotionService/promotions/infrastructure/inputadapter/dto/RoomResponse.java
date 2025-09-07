package com.service.promotionService.promotions.infrastructure.inputadapter.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class RoomResponse {
    public UUID id;
    public UUID hotelId;
    public String roomNumber;
    public BigDecimal pricePerDay;
    public BigDecimal maintenanceCostPerDay;
    public String description;
    public Integer capacity;
    public String state;
}
