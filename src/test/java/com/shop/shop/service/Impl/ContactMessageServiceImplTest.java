package com.shop.shop.service.Impl;

import com.shop.shop.dao.ContactMessageDao;
import com.shop.shop.dto.ContactMessageDto;
import com.shop.shop.repository.ContactMessageRepository;
import com.shop.shop.service.ContactMessageService;
import com.shop.shop.service.Impl.ContactMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class ContactMessageServiceImplTest {

    @Autowired
    ContactMessageService contactMessageService;

    @Autowired
    ContactMessageRepository contactMessageRepository;

    @Autowired
    ContactMessageDao contactMessageDao;

    @Test
    void addMessage() {
        ContactMessageDto contactMessageDto = new ContactMessageDto();
        contactMessageDto.setFullName("Test");
        contactMessageDto.setEmail("Test");
        contactMessageDto.setSubject("Test");
        contactMessageDto.setMessage("Test");
        contactMessageService.addMessage(contactMessageDto);
        assertEquals(contactMessageRepository.findAll().size(), 1);
    }
}