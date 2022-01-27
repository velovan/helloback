package com.hello.service;

import com.hello.entity.Contact;
import com.hello.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class ContactServiceImpl implements ContactService{

	private final ContactRepository repository;

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	public ContactServiceImpl(ContactRepository repository){
	    this.repository = repository;
	}

	@Override
	public List<Contact> getFilteredContacts(String regex, boolean forward, long lastId, int limit) {
	    return repository.getFilteredContacts(regex, forward, lastId, limit).stream().sorted((o1, o2) -> ((int) (o1.getId() - o2.getId()))).collect(Collectors.toList());
	}
}
