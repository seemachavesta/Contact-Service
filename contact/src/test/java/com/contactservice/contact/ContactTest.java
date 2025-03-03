package com.contactservice.contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactCreationValid() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    // Test for null ID
    @Test
    void testContactCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
    }

    // Test for ID too long
    @Test
    void testContactCreationWithLongId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St"));
    }

    // Test for null first name
    @Test
    void testContactCreationWithNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Elm St"));
    }

    // Test for first name too long
    @Test
    void testContactCreationWithLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "VeryLongFirstName", "Doe", "1234567890", "123 Elm St"));
    }

    // Test for null last name
    @Test
    void testContactCreationWithNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Elm St"));
    }

    // Test for last name too long
    @Test
    void testContactCreationWithLongLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "VeryLongLastName", "1234567890", "123 Elm St"));
    }

    // Test for null phone
    @Test
    void testContactCreationWithNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Elm St"));
    }

    // Test for phone not exactly 10 digits
    @Test
    void testContactCreationWithInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345", "123 Elm St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "123456789012", "123 Elm St"));
    }

    // Test for phone containing non-numeric characters
    @Test
    void testContactCreationWithNonNumericPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "abcdefghij", "123 Elm St"));
    }

    // Test for null address
    @Test
    void testContactCreationWithNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
    }

    // Test for address too long
    @Test
    void testContactCreationWithLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }
}

