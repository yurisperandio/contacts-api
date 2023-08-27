package io.github.yurisperandio.contactsapi;

import io.github.yurisperandio.contactsapi.model.entity.Contact;
import io.github.yurisperandio.contactsapi.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApiApplication.class, args);
	}

}
