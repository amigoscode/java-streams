package com.amigoscode.examples;

import com.amigoscode.beans.Person;

import java.util.ArrayList;
import java.util.List;

class GettingStarted {

    private final List<Person> people;

    GettingStarted(List<Person> people) {
        this.people = people;
    }

    List<Person> imperativeApproach() {
        var youngPeople = new ArrayList<Person>();
        var limit = 10;
        var counter = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
            }
            if (counter == limit) {
                break;
            }
        }
        return youngPeople;
    }

    List<Person> declarativeApproachUsingStreams() {
        return people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .toList();
    }
}
