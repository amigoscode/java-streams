package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WorkingWithStreamsTest {

    @Test
    void count_items_on_stream() {
        var names = List.of("Amigoscode", "Alex", "Zara", "Sarah", "Alan");
        var stream = names.stream();

        var count = stream
                .filter(name -> name.charAt(0) == 'A')
                .limit(2)
                .count();

        assertThat(count).isEqualTo(2);
    }
}
