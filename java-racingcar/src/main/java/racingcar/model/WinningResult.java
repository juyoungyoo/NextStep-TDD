package racingcar.model;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.model.Car.DEFAULT_POSITION;

public class WinningResult {

    public static List<String> ofWinningCars(Cars cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.getCars().stream()
                .filter(car -> car.isMatchPosition(maxPosition))
                .map(Car::getName)
                .collect(toList());
    }

    private static int getMaxPosition(Cars cars) {
        return cars.getCars().stream()
                    .mapToInt(Car::getPosition)
                    .max()
                    .orElse(DEFAULT_POSITION);
    }
}
