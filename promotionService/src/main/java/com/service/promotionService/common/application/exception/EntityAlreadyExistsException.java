package com.service.promotionService.common.application.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message){ super(message); }
}
