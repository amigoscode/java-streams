package com.amigoscode.examples;

import com.amigoscode.beans.Car;

import java.util.List;
import java.util.function.Predicate;

class Filtering {

    private final Predicate<Car> price = car -> car.getPrice() < 20_000.00;
    private final Predicate<Car> color = car -> car.getColor().equals("Yellow");
    private final List<Car> cars;

    Filtering(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> getYellowCarsUnder20k() {
        return cars.stream()
                .filter(price)
                .filter(color)
                .toList();
    }
}