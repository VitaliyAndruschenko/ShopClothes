package com.shop.shop.dao.impl;

import com.shop.shop.dao.ContactMessageDao;
import com.shop.shop.model.ContactMessage;
import com.shop.shop.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactMessageDaoImpl extends ContactMessageDao {
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    @Override
    public void addMessage(ContactMessage contactMessage) {
        contactMessageRepository.save(contactMessage);
    }
}
