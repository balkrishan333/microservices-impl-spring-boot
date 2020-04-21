package com.nagpal.webservices.rest.post;

import com.nagpal.webservices.rest.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();

    @Autowired
    private UserDaoService userDaoService;

    private boolean initialized = false;

    public List<Post> fetchAllPostForUser(int userId) {
        if (!initialized) {
            initialize();
        }
        return posts.stream().filter(post -> post.getUser().getId() == userId).collect(Collectors.toList());
    }

    private void initialize() {
        posts.add(new Post("Post 1", new Date(), userDaoService.find(1)));
        posts.add(new Post("Post 2", new Date(), userDaoService.find(2)));
        posts.add(new Post("Post 3", new Date(), userDaoService.find(2)));
        posts.add(new Post("Post 4", new Date(), userDaoService.find(3)));
        posts.add(new Post("Post 5", new Date(), userDaoService.find(3)));
        posts.add(new Post("Post 6", new Date(), userDaoService.find(3)));

        initialized = true;
    }
}
