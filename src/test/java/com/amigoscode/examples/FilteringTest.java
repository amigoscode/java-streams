package com.amigoscode.examples;

import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FilteringTest {

    @Test
    void get_all_yellow_cars_under_20k() throws Exception {
        var cars = MockData.getCars();
        var filtering = new Filtering(cars);

        var carsUnder20k = filtering.getYellowCarsUnder20k();

        assertThat(carsUnder20k.size()).isEqualTo(9);
        carsUnder20k.forEach(car ->
                assertThat(car.getPrice()).isLessThan(20_000.00));
    }

    @Test
    void dropWhile() throws Exception {
        System.out.println("using filtering");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
    }

    @Test
    void takeWhile() throws Exception {
        // using filtering
        System.out.println("using filtering");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }

    @Test
    void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
    }

    @Test
    void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
    }

    @Test
    void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
    }

}



