package com.service.promotionService.promotions.infrastructure.outputadapter;

import com.service.promotionService.promotions.application.ports.output.*;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.infrastructure.outputadapter.Persistence.entity.PromotionsDBEntity;
import com.service.promotionService.promotions.infrastructure.outputadapter.Persistence.repository.PromotionsDBRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PromotionsRepositoryOutputAdapter implements SavePromotionsOutputPort,
        UpdatePromotionsOutputPort, DeletePromotionsOutputPort,
        FindPromotionsByIdOutputPort, FindingAllPromotionsOutputPort,
        FindPromotionsByHotelOutputPort, FindPromotionsByRestaurantOutputPort,
        FindPromotionsByRoomOutputPort{

    private final PromotionsDBRepository repository;

    public PromotionsRepositoryOutputAdapter(PromotionsDBRepository repository) {
        this.repository = repository;
    }

    private PromotionsDomainEntity toDomain(PromotionsDBEntity e){
        return PromotionsDomainEntity.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .type(e.getType())
                .discountPercentage(e.getDiscountPercentage())
                .startDate(e.getStartDate())
                .endDate(e.getEndDate())
                .hotelId(e.getHotelId())
                .restaurantId(e.getRestaurantId())
                .customerId(e.getCustomerId())
                .roomId(e.getRoomId())
                .dishId(e.getDishId())
                .build();
    }

    private PromotionsDBEntity toEntity(PromotionsDomainEntity d){
        return PromotionsDBEntity.builder()
                .id(d.getId())
                .name(d.getName())
                .description(d.getDescription())
                .type(d.getType())
                .discountPercentage(d.getDiscountPercentage())
                .startDate(d.getStartDate())
                .endDate(d.getEndDate())
                .hotelId(d.getHotelId())
                .restaurantId(d.getRestaurantId())
                .customerId(d.getCustomerId())
                .roomId(d.getRoomId())
                .dishId(d.getDishId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    @Override
    public PromotionsDomainEntity save(PromotionsDomainEntity promotions) {
        PromotionsDBEntity e = toEntity(promotions);
        PromotionsDBEntity saved = repository.save(e);
        return toDomain(saved);
    }

    @Override
    public PromotionsDomainEntity update(Integer id, PromotionsDomainEntity promotions) {
        PromotionsDBEntity e = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        e.setName(promotions.getName());
        e.setDescription(promotions.getDescription());
        e.setType(promotions.getType());
        e.setDiscountPercentage(promotions.getDiscountPercentage());
        e.setStartDate(promotions.getStartDate());
        e.setEndDate(promotions.getEndDate());
        e.setHotelId(promotions.getHotelId());
        e.setRestaurantId(promotions.getRestaurantId());
        e.setCustomerId(promotions.getCustomerId());
        e.setRoomId(promotions.getRoomId());
        e.setDishId(promotions.getDishId());
        PromotionsDBEntity updated = repository.save(e);
        return toDomain(updated);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<PromotionsDomainEntity> findById(Integer id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<PromotionsDomainEntity> findAll() {
        return repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PromotionsDomainEntity> findByHotelId(UUID hotelId) {
        return repository.findByHotelId(hotelId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromotionsDomainEntity> findByRestaurantId(UUID restaurantId) {
        return repository.findByRestaurantId(restaurantId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromotionsDomainEntity> getPromotionsByRoom(UUID roomId) {
        return repository.findByRoomId(roomId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
