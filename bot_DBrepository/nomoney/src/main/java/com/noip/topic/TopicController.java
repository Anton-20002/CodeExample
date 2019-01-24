package com.noip.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Anton on 13.08.2018.
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getAllTopics(){
        return topicService.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getTopic(@PathVariable String id){
        return topicService.getUser(Integer.parseInt(id));
    }

    @RequestMapping (value = "/user/{log},{pass}", method = RequestMethod.POST)
    public void addUser(@PathVariable String log,
                        @PathVariable String pass){
        int i = topicService.checkId();
        User user = new User(i+1, log, pass);
        topicService.add(user);
    }

    @RequestMapping (value = "/user/{id},{log},{pas}", method = RequestMethod.PUT)
    public String addUser(@PathVariable String id,
                        @PathVariable String log,
                        @PathVariable String pas){
        return topicService.updateUser(Integer.parseInt(id), log, pas);
    }

    @RequestMapping (value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteTopic(@PathVariable String id){
        return topicService.deleteTopic(Integer.parseInt(id));
    }


}
