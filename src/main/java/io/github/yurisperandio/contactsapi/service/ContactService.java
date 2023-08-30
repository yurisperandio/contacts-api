package io.github.yurisperandio.contactsapi.service;

import io.github.yurisperandio.contactsapi.model.entity.Contact;
import io.github.yurisperandio.contactsapi.model.repository.ContactRepository;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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

    public Page<Contact> findAll(PageRequest pageRequest){
        return repository.findAll(pageRequest);
    }

    public void favorite(Integer id) {
        Optional<Contact> contact = repository.findById(id);
        contact.ifPresent(c -> {
            boolean favorite = c.getFavorite() == Boolean.TRUE;
            c.setFavorite(!favorite);
            repository.save(c);
        });
    }

    public Serializable addPhoto(Integer id, Part file) {
        Optional<Contact> contact = repository.findById(id);
        return contact.map(c -> {
            try{
                InputStream is = file.getInputStream();
                byte[] bytes = new byte[(int) file.getSize()];
                IOUtils.readFully(is, bytes);
                c.setPhoto(bytes);
                repository.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return e;
            }
        }).orElse(null);
    }
}
