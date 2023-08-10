package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;


class GettingStartedTest {

    private static final String FAILED_TO_FETCH_MOCK_DATA_FOR_THE_TEST = "Failed to fetch mock data for the test";
    private GettingStarted gettingStarted;
    private List<Person> people;

    @BeforeEach
    void setup() {
        try {
            people = MockData.getPeople();
        } catch (IOException e) {
            fail(FAILED_TO_FETCH_MOCK_DATA_FOR_THE_TEST);
        }
        gettingStarted = new GettingStarted(people);
    }

    @Test
    void imperative_approach() {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people

        var youngPeople = gettingStarted.imperativeApproach();

        assertThat(youngPeople.size()).isEqualTo(10);
        for (Person person : youngPeople) {
            assertThat(person.getAge()).isLessThanOrEqualTo(18);
        }
    }

    @Test
    void declarativeApproachUsingStreams() {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people

        var youngPeople = gettingStarted.declarativeApproachUsingStreams();

        assertThat(youngPeople.size()).isEqualTo(10);
        for (Person person : youngPeople) {
            assertThat(person.getAge()).isLessThanOrEqualTo(18);
        }
    }
}
