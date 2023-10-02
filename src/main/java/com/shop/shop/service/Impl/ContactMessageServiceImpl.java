package com.shop.shop.service.Impl;

import com.shop.shop.dao.ContactMessageDao;
import com.shop.shop.dao.UserDAO;
import com.shop.shop.dto.ContactMessageDto;
import com.shop.shop.model.ContactMessage;
import com.shop.shop.model.User;
import com.shop.shop.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
