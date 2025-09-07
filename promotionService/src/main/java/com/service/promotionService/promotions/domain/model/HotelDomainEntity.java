package com.service.promotionService.promotions.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class HotelDomainEntity {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private Integer totalRooms;

}
