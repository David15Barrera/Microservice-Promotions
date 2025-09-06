package com.service.promotionService.promotions.infrastructure.inputadapter.rest;

import com.service.promotionService.promotions.application.ports.input.*;
import com.service.promotionService.promotions.domain.model.PromotionsDomainEntity;
import com.service.promotionService.promotions.infrastructure.inputadapter.dto.*;
import com.service.promotionService.promotions.infrastructure.inputadapter.mapper.PromotionsMapperRest;
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

    public PromotionsControllerAdapter(CreatePromotionsInputPort createUseCase,
                                       UpdatePromotionsInputPort updateUseCase,
                                       GetPromotionsByIdInputPort getUseCase,
                                       DeletePromotionsInputPort deleteUseCase,
                                       ListAllPromotionsInputPort listUseCase, GetPromotionsByHotelInputPort getPromotionsByHotelInputPort, GetPromotionsByRestaurantInputPort getPromotionsByRestaurantInputPort, GetPromotionsByRoomInputPort getPromotionsByRoomInputPort) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getUseCase = getUseCase;
        this.deleteUseCase = deleteUseCase;
        this.listUseCase = listUseCase;
        this.getPromotionsByHotelInputPort = getPromotionsByHotelInputPort;
        this.getPromotionsByRestaurantInputPort = getPromotionsByRestaurantInputPort;
        this.getPromotionsByRoomInputPort = getPromotionsByRoomInputPort;
    }


    @PostMapping
    public ResponseEntity<PromotionsResponseDto> create(@RequestBody PromotionsRequestDto dto){
        PromotionsDomainEntity domain = PromotionsMapperRest.toDomain(dto);
        PromotionsDomainEntity created = createUseCase.create(domain);
        return ResponseEntity.ok(PromotionsMapperRest.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionsResponseDto> get(@PathVariable Integer id){
        PromotionsDomainEntity found = getUseCase.getById(id);
        return ResponseEntity.ok(PromotionsMapperRest.toResponse(found));
    }

    @GetMapping
    public ResponseEntity<List<PromotionsResponseDto>> listAll(){
        var list = listUseCase.listAll();
        var resp = list.stream().map(PromotionsMapperRest::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionsResponseDto> update(@PathVariable Integer id, @RequestBody PromotionsRequestDto dto){
        var domain = PromotionsMapperRest.toDomain(dto);
        var updated = updateUseCase.update(id, domain);
        return ResponseEntity.ok(PromotionsMapperRest.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        deleteUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-hotel/{hotelId}")
    public List<PromotionsDomainEntity> getPromotionsByHotel(@PathVariable UUID hotelId) {
        return getPromotionsByHotelInputPort.getPromotionsByHotel(hotelId);
    }

    @GetMapping("/by-restaurant/{restaurantId}")
    public List<PromotionsDomainEntity> getPromotionsByRestaurant(
            @PathVariable java.util.UUID restaurantId) {
        return getPromotionsByRestaurantInputPort.getPromotionsByRestaurant(restaurantId);
    }

    @GetMapping("/by-room/{roomId}")
    public List<PromotionsDomainEntity> getPromotionsByRoom(
            @PathVariable java.util.UUID roomId) {
        return getPromotionsByRoomInputPort.getPromotionsByRoom(roomId);
    }
}
