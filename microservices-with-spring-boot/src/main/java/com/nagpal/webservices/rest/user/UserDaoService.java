package com.nagpal.webservices.rest.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, new Date(), "A"));
        users.add(new User(2, new Date(), "B"));
        users.add(new User(3, new Date(), "C"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User find(int id) {
       for (User user : users) {
           if (Integer.compare(user.getId(), id) == 0) {
               return user;
           }
       }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                usersCount--;
                return user;
            }
        }
        return null;
    }

}
