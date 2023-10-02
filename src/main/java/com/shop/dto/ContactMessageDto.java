package com.shop.dto;

import lombok.Data;

@Data
public class ContactMessageDto {
    private String fullName;
    private String email;
    private String subject;
    private String message;
}
