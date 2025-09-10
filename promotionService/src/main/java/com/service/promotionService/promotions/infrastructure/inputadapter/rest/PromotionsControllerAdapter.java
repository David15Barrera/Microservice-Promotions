package com.service.promotionService.promotions.infrastructure.inputadapter.rest;

import com.service.promotionService.promotions.application.ports.input.*;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.*;
import com.service.promotionService.promotions.infrastructure.inputadapter.mapper.PromotionsMapperRest;
import com.service.promotionService.promotions.infrastructure.outputadapter.factory.PromotionsWithRelationsFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionsControllerAdapter {

    private final CreatePromotionsInputPort createUseCase;
    private final UpdatePromotionsInputPort updateUseCase;
    private final GetPromotionsByIdInputPort getUseCase;
    private final DeletePromotionsInputPort deleteUseCase;
    private final ListAllPromotionsInputPort listUseCase;
    private final GetPromotionsByHotelInputPort getPromotionsByHotelInputPort;
    private final GetPromotionsByRestaurantInputPort getPromotionsByRestaurantInputPort;
    private final GetPromotionsByRoomInputPort getPromotionsByRoomInputPort;
    private final PromotionsWithRelationsFactory promotionsFactory;

    public PromotionsControllerAdapter(CreatePromotionsInputPort createUseCase,
                                       UpdatePromotionsInputPort updateUseCase,
                                       GetPromotionsByIdInputPort getUseCase,
                                       DeletePromotionsInputPort deleteUseCase,
                                       ListAllPromotionsInputPort listUseCase, GetPromotionsByHotelInputPort getPromotionsByHotelInputPort, GetPromotionsByRestaurantInputPort getPromotionsByRestaurantInputPort, GetPromotionsByRoomInputPort getPromotionsByRoomInputPort, PromotionsWithRelationsFactory promotionsFactory) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getUseCase = getUseCase;
        this.deleteUseCase = deleteUseCase;
        this.listUseCase = listUseCase;
        this.getPromotionsByHotelInputPort = getPromotionsByHotelInputPort;
        this.getPromotionsByRestaurantInputPort = getPromotionsByRestaurantInputPort;
        this.getPromotionsByRoomInputPort = getPromotionsByRoomInputPort;
        this.promotionsFactory = promotionsFactory;
    }



    @GetMapping
    public ResponseEntity<List<PromotionsResponseDto>> listAll() {
        List<PromotionsDomainEntity> all = listUseCase.listAll();
        List<PromotionsResponseDto> resp = promotionsFactory.fromDomainList(all);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionsResponseDto> get(@PathVariable UUID id){
        PromotionsDomainEntity found = getUseCase.getById(id);
        return ResponseEntity.ok(promotionsFactory.fromDomain(found));
    }

    @PostMapping
    public ResponseEntity<PromotionsResponseDto> create(@RequestBody PromotionsRequestDto dto){
        PromotionsDomainEntity created = createUseCase.create(PromotionsMapperRest.toDomain(dto));
        return ResponseEntity.ok(promotionsFactory.fromDomain(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionsResponseDto> update(@PathVariable UUID id, @RequestBody PromotionsRequestDto dto){
        PromotionsDomainEntity updated = updateUseCase.update(id, PromotionsMapperRest.toDomain(dto));
        return ResponseEntity.ok(promotionsFactory.fromDomain(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        deleteUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-hotel/{hotelId}")
    public ResponseEntity<List<PromotionsResponseDto>> getPromotionsByHotel(@PathVariable UUID hotelId) {
        List<PromotionsDomainEntity> promotions = getPromotionsByHotelInputPort.getPromotionsByHotel(hotelId);
        List<PromotionsResponseDto> response = promotionsFactory.fromDomainList(promotions);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    public ResponseEntity<List<PromotionsResponseDto>> getPromotionsByRestaurant(@PathVariable UUID restaurantId) {
        List<PromotionsDomainEntity> promotions = getPromotionsByRestaurantInputPort.getPromotionsByRestaurant(restaurantId);
        List<PromotionsResponseDto> response = promotionsFactory.fromDomainList(promotions);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-room/{roomId}")
    public ResponseEntity<List<PromotionsResponseDto>> getPromotionsByRoom(@PathVariable UUID roomId) {
        List<PromotionsDomainEntity> promotions = getPromotionsByRoomInputPort.getPromotionsByRoom(roomId);
        List<PromotionsResponseDto> response = promotionsFactory.fromDomainList(promotions);
        return ResponseEntity.ok(response);
    }

}
