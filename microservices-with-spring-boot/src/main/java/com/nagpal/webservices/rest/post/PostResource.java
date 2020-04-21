package com.nagpal.webservices.rest.post;

import com.nagpal.webservices.rest.user.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postDaoService;

    @GetMapping(path = "users/{userId}/posts")
    public List<EntityModel<Post>> fetchAllPostForUser(@PathVariable int userId) {
        List<Post> posts = postDaoService.fetchAllPostForUser(userId);

        List<EntityModel<Post>> entityModelList = new ArrayList<>();

        for(Post post : posts) {
            EntityModel<Post> entityModel = new EntityModel<>(post);
            WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).retrieveAllUsers());

            entityModel.add(linkBuilder.withRel("users"));
            entityModelList.add(entityModel);
        }

        return entityModelList;
    }
}
