package io.github.yurisperandio.contactsapi.service;

import io.github.yurisperandio.contactsapi.model.entity.Contact;
import io.github.yurisperandio.contactsapi.model.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public Contact save(Contact contact){
        return repository.save(contact);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public List<Contact> findAll(){
        return repository.findAll();
    }

    public void favorite(Integer id, Boolean favorite) {
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent(c -> {
            c.setFavorite(favorite);
            repository.save(c);
        });
    }
}
