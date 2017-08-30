package com.hello.controller;

import com.hello.entity.Contact;
import com.hello.service.ContactService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello/contacts")
public class ContactController {

    private final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService service;
    private long maxVal = 1000000;
    
    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> getFilteredContact(
            @RequestParam(name = "nameFilter") String regex,
            @RequestParam(name = "forward") Boolean forward,
            @RequestParam(name = "lastId", required = false) Long lastId,
            @RequestParam(name = "limit", required = false) Integer limit) {

    	 if (limit <= 0|| limit.equals("")) {
            log.info("Bad request, limit > default");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    	long lastIdParam = lastId == null ? 0 : lastId;
        int limitParam = (int) (limit == null ? maxVal : limit);

        List<Contact> contacts = service.getFilteredContacts(regex, forward, lastIdParam, limitParam);

        if (contacts.isEmpty()) {
            log.info("Contacts Not Found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Get filtered contacts");
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
}
