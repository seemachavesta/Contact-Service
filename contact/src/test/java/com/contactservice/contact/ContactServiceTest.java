package com.contactservice.contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Oak St");
        assertEquals("Jane", service.getContact("12345").getFirstName());
        assertEquals("Smith", service.getContact("12345").getLastName());
        assertEquals("0987654321", service.getContact("12345").getPhone());
        assertEquals("456 Oak St", service.getContact("12345").getAddress());
    }
}

