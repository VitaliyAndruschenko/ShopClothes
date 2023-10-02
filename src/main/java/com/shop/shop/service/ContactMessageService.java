package com.shop.shop.service;

import com.shop.shop.dto.ContactMessageDto;
import com.shop.shop.model.User;
import org.springframework.stereotype.Service;

@Service
public interface ContactMessageService {
    void addMessage(ContactMessageDto contactMessageDto);
}
