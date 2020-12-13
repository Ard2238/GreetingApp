package com.spring.greeting.controller;

import com.spring.greeting.model.Greeting;
import com.spring.greeting.model.User;
import com.spring.greeting.services.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("")
    public Greeting greeting(@RequestParam(value ="firstName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName){
        //return new Greeting(counter.incrementAndGet(), String.format(template,name));
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return  greetingService.addGreeting(user);
    }

    @PutMapping("/put/{id}")
    public Greeting updateGreeting(@PathVariable long id,@RequestParam(value = "message") String message){
        return greetingService.updateGreeting(id,message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGreeting(@PathVariable long id){
        greetingService.deleteGreeting(id);
    }
}
