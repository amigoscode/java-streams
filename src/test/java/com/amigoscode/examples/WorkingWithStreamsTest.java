package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WorkingWithStreamsTest {

    @Test
    void count_items_on_stream() {
        var names = List.of("Amigoscode", "Alex", "Zara");
        var stream = names.stream();

        var count = stream.limit(2)
                .map(null)
                .sorted(null)
                .dropWhile(null)
                .count();

        assertThat(count).isEqualTo(2);
    }
}
