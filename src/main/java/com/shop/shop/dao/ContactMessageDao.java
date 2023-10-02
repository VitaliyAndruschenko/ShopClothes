package com.shop.shop.dao;

import com.shop.shop.dto.ContactMessageDto;
import com.shop.shop.model.ContactMessage;

public abstract class ContactMessageDao {
    public abstract void addMessage(ContactMessage contactMessage);
}
