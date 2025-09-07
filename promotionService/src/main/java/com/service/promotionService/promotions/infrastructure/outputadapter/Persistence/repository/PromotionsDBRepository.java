package com.service.promotionService.promotions.infrastructure.outputadapter.Persistence.repository;

import com.service.promotionService.promotions.infrastructure.outputadapter.Persistence.entity.PromotionsDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PromotionsDBRepository extends JpaRepository<PromotionsDBEntity, UUID> {
    List<PromotionsDBEntity> findByHotelId(java.util.UUID hotelId);
    List<PromotionsDBEntity> findByRestaurantId(UUID restaurantId);
    List<PromotionsDBEntity> findByRoomId(UUID roomId);
}
