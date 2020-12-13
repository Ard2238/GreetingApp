package com.spring.greeting.services;

import com.spring.greeting.model.Greeting;
import com.spring.greeting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, user.toString().isEmpty()? "Hello World": user.toString());
        return greetingRepository.save(new Greeting(counter, message));
    }

    @Override
    public Optional<Greeting> getGreeting(long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public Greeting updateGreeting(long id, String message) {
        Greeting greeting = greetingRepository.findById(id).orElse(null);
        if(greeting != null) {
            greeting.setGreeting(message);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }


}
