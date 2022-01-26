package com.hello.service;

import java.util.List;

import com.hello.entity.Contact;
 
public interface ContactService {

    List<Contact> getFilteredContacts(String regex, boolean forward, long lastId, int limit);

}
