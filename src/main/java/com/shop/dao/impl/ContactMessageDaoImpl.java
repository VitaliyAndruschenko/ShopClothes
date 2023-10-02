package com.shop.dao.impl;

import com.shop.dao.ContactMessageDao;
import com.shop.model.ContactMessage;
import com.shop.repository.ContactMessageRepository;
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
