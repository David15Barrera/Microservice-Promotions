package com.service.promotionService.promotions.infrastructure.outputadapter.Persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "promotion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionsDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String type;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    private LocalDate startDate;
    private LocalDate endDate;

    private UUID hotelId;
    private UUID restaurantId;
    private UUID customerId;
    private UUID roomId;
    private UUID dishId;

    private LocalDateTime createdAt;
}
