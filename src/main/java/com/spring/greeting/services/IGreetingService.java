package com.spring.greeting.services;

import com.spring.greeting.model.Greeting;
import com.spring.greeting.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Optional<Greeting> getGreeting(long id);

    Greeting updateGreeting(long id, String message);
    void deleteGreeting(long id);

    public List<Greeting> getAllGreetings();
}
