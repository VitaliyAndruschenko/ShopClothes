package com.shop.service.Impl;

import com.shop.dao.ContactMessageDao;
import com.shop.dto.ContactMessageDto;
import com.shop.model.ContactMessage;
import com.shop.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {
    @Autowired
    public ContactMessageDao contactMessageDao;
    @Override
    public void addMessage(ContactMessageDto contactMessageDto) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setFullName(contactMessageDto.getFullName());
        contactMessage.setEmail(contactMessageDto.getEmail());
        contactMessage.setSubject(contactMessageDto.getSubject());
        contactMessage.setMessage(contactMessageDto.getMessage());
        contactMessageDao.addMessage(contactMessage);
    }
}
