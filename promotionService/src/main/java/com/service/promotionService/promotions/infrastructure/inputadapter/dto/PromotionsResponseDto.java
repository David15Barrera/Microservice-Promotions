package com.service.promotionService.promotions.infrastructure.inputadapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionsResponseDto {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID hotelId;
    private UUID restaurantId;
    private UUID customerId;
    private UUID roomId;
    private Integer dishId;
}
