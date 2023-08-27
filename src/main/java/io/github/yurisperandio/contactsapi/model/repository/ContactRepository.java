package io.github.yurisperandio.contactsapi.model.repository;

import io.github.yurisperandio.contactsapi.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
