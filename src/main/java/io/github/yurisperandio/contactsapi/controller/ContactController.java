package io.github.yurisperandio.contactsapi.controller;

import io.github.yurisperandio.contactsapi.model.entity.Contact;
import io.github.yurisperandio.contactsapi.service.ContactService;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@CrossOrigin
public class ContactController {

    private final ContactService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save( @RequestBody Contact contact){
        return service.save(contact);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<Contact> findContact(){
        return service.findAll();
    }

    @PatchMapping("/{id}/favorite")
    public void favorite(@PathVariable Integer id){
        service.favorite(id);
    }

    @PutMapping("{id}/photo")
    public Serializable addPhoto(@PathVariable Integer id, @RequestParam("photo") Part file){
        return service.addPhoto(id, file);
    }
}
