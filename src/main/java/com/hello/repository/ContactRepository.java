package com.hello.repository;

import java.util.List;

import com.hello.entity.Contact;
 
public interface ContactRepository {

    List<Contact> getFilteredContacts(String regex, boolean forward, long lastId, int limit);
}
