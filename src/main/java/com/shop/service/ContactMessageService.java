package com.shop.service;

import com.shop.dto.ContactMessageDto;
import org.springframework.stereotype.Service;

@Service
public interface ContactMessageService {
    void addMessage(ContactMessageDto contactMessageDto);
}
