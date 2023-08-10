package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TransformationsMapAndReduceTest {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        var peopleDTos = people.stream()
                .map(PersonDTO::map)
                .toList();

        assertThat(people.size()).isEqualTo(peopleDTos.size());
        peopleDTos.forEach(personDTO -> {
            long count = people.stream()
                    .filter(person -> person.getId() == personDTO.getId())
                    .count();
            assertThat(count).isEqualTo(1);
        });
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        var cars = MockData.getCars();

        double averageCarPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .getAsDouble();

        assertThat(averageCarPrice).isEqualTo(52693.19979);
    }

    @Test
    void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        var reduced = Arrays.stream(integers)
                .reduce(0, Integer::sum);

        assertThat(reduced).isEqualTo(1831);
    }
}

