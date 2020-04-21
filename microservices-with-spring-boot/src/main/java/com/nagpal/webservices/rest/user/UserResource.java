package com.nagpal.webservices.rest.user;

import com.nagpal.webservices.rest.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserDaoService daoService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
//        return daoService.findAll();
        return userRepository.findAll();
    }

    @GetMapping(path = "users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = daoService.find(id);
        if (user == null) {
            throw new UserNotFoundException("Id: " + id);
        }

        //HATEOAS
        EntityModel<User> entityModel = new EntityModel<>(user);
        WebMvcLinkBuilder allUsersLink = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        //for testing multiple links, link to same method, practically this will be link to some other method
        WebMvcLinkBuilder getUserLink = linkTo(methodOn(this.getClass()).retrieveUser(id));

        entityModel.add(allUsersLink.withRel("all-users")).add(getUserLink.withRel("this-user"));
        return entityModel;
    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = daoService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("Id: " + id);
        }
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = daoService.save(user);

        URI currentReqURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(currentReqURI).build();
    }
}
