package com.spring.greeting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
    @Id
    private AtomicLong counter;
    private String greeting;

    public Greeting() {
        greeting = "";
    }

    public Greeting(AtomicLong counter, String greeting){
        this.counter = counter;
        this.greeting = greeting;
    }

    public AtomicLong getCounter() {
        return counter;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setCounter(AtomicLong counter) {
        this.counter = counter;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
