package com.noip.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Anton on 13.08.2018.
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<User> getUsers() {
     return topicRepository.findAll();
    }

    User getUser(int id) {
        Optional<User> user = topicRepository.findById(id);
        return user.orElse(new User(0,"NONE", "NONE"));
    }

    void add(User user){
        topicRepository.save(user);
    }


    String updateUser(int id, String login, String password) {
        Optional<User> user = topicRepository.findById(id);
        if (user.isPresent()) {
            User user1 = user.get();
            user1.setLogin(login);
            user1.setPassword(password);
            topicRepository.save(user1);
            return "Updated success!";
        }else {
            return "No user by Id: "+ id;
        }
    }


    String deleteTopic(int id) {
        Optional<User> user = topicRepository.findById(id);
        if (user.isPresent()) {
            User user1 = user.get();
            String ID = String.valueOf(user1.getId());
            String Login = user1.getLogin();
            String Password = user1.getPassword();
            topicRepository.deleteById(id);
            return "Deleted: UserID-" + ID + " Login-" + Login + " Password-" + Password;
        }else {
            return "No user by Id: "+ id;
        }
    }

    int checkId(){
        List<User> users = topicRepository.findAll();
        return users.size();

    }
}


