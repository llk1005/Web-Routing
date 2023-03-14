package edu.sru.thangiah.webrouting.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import edu.sru.thangiah.webrouting.domain.Contacts;
import edu.sru.thangiah.webrouting.repository.ContactsRepository;

//****IMPORTANT***
//****Make sure to have the "test" data base in the application.properties selected for running tests until tests files are all completed.****
//****Make sure spring.jpa.hibernate.ddl-auto=create is set for test database. That way it will create the database each time.****

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactsControllerTest {

	@Autowired
	ContactsRepository contactsRepository;
	
	Contacts contact;
	Contacts contact1;
	
	Iterable<Contacts> listContacts = new ArrayList<>();

	
	
	@BeforeEach
	void setUp() throws Exception {
		
		contact =new Contacts();
		contact.setFirstName("Ian");
		contact.setLastName("black");
		contact.setMiddleInitial("M");
		contact.setEmailAddress("here");
		contact.setPrimaryPhone("111");
		contact.setWorkPhone("111");
		contact.setCity("Kittanning");
		contact.setState("State");
		contact.setStreetAddress1("143 round");
		contact.setStreetAddress2("111");
		contact.setZip("16201");
		
		contact1 = new Contacts();
		contact1.setFirstName("Bob");
		contact1.setLastName("White"); 
		contact1.setMiddleInitial("M");
		contact1.setEmailAddress("here");
		contact1.setPrimaryPhone("111");
		contact1.setWorkPhone("111");
		contact1.setCity("Kittanning");
		contact1.setState("State");
		contact1.setStreetAddress1("round");
		contact1.setStreetAddress2("111");
		contact1.setZip("16201");
		
		
	}

	@Test
	@Order(1)
	@Rollback(value=false)
	void testAddContact() {
		
		contactsRepository.save(contact);
		assertNotNull(contact.getLastName());
		assertNotNull(contact.getFirstName());
		assertNotNull(contact.getEmailAddress());
		assertNotNull(contact.getPrimaryPhone());
		assertNotNull(contact.getCity());
		assertNotNull(contact.getState());
		assertNotNull(contact.getStreetAddress1());
		assertNotNull(contact.getZip());
		assertEquals(contact.getId(), 1L);
		
		contactsRepository.save(contact1);
		assertNotNull(contact1.getLastName());
		assertNotNull(contact1.getFirstName());
		assertNotNull(contact1.getEmailAddress());
		assertNotNull(contact1.getPrimaryPhone());
		assertNotNull(contact1.getCity());
		assertNotNull(contact1.getState());
		assertNotNull(contact1.getStreetAddress1());
		assertNotNull(contact1.getZip());
		assertEquals(contact1.getId(), 2L);
		
		System.out.println();
		assertNotSame(contact.getId(), contact1.getId());
		
	}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	void testDeleteContact() {
		Contacts deleteContact = contactsRepository.findById(1L).get();
		
		
		contactsRepository.delete(deleteContact);
		
		
		Contacts contactCheck = null;
		
		//Contacts deleteContact2 = contactsRepository.findById(2L).get();
		//contactsRepository.delete(deleteContact2);
		
		Optional<Contacts> optionalContact = contactsRepository.findById(1L);
		
		if(optionalContact.isPresent()) {
			contactCheck = optionalContact.get();
		}
		
		Assertions.assertThat(contactCheck).isNull();
	     
	}
	@Test
	@Order(3)
	@Rollback(value=false)
	void testUpdateContact() {
		
		contact1.setFirstName("Ron");
		contact1.setLastName("Toy"); 
		contact1.setMiddleInitial("A");
		contact1.setEmailAddress("there");
		contact1.setPrimaryPhone("222");
		contact1.setWorkPhone("333");
		contact1.setCity("Ford City");
		contact1.setState("PA");
		contact1.setStreetAddress1("this street");
		contact1.setStreetAddress2("333");
		contact1.setZip("16226");
		
		assertNotSame(contact1.getFirstName(), "Bob");
		assertNotSame(contact1.getLastName(), "White");
		assertNotSame(contact1.getMiddleInitial(), "M");
		assertNotSame(contact1.getEmailAddress(), "here");
		assertNotSame(contact1.getPrimaryPhone(), "111");
		assertNotSame(contact1.getWorkPhone(), "111");
		assertNotSame(contact1.getCity(), "Kittanning");
		assertNotSame(contact1.getState(), "State");
		assertNotSame(contact1.getStreetAddress1(), "round");
		assertNotSame(contact1.getStreetAddress2(), "111");
		assertNotSame(contact1.getZip(), "16201");
	}

	@Test
	@Order(4)
	@Rollback(value=false)
	void showListContact() {
		listContacts = contactsRepository.findAll();
		System.out.println(listContacts + "here is all our contacts");
		assertFalse(((ArrayList<Contacts>) listContacts).isEmpty());
	}

}
