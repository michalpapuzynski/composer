package pl.michalpapuzynski.composer.model;

import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class SongRequirements {

    private final Mood mood;
    private final int chordsNumber;

    public double getMaxMinorPercentage() {
        switch (mood) {
            case LIVELY:
                return 25d;
            case POP:
                return 50d;
            case CALM:
                return 25d;
            case SAD:
                return 75d;
            default:
                return 0;

        }
    }

    public List<Integer> getTempoInterval() {

        switch (mood) {
            case LIVELY:
                return IntStream.rangeClosed(120, 160)
                        .filter(n -> n % 10 == 0)
                        .boxed()
                        .collect(Collectors.toList());
            case POP:
                return IntStream.rangeClosed(120, 140)
                        .filter(n -> n % 10 == 0)
                        .boxed()
                        .collect(Collectors.toList());
            case CALM:
                return IntStream.rangeClosed(100, 120)
                        .filter(n -> n % 5 == 0)
                        .boxed()
                        .collect(Collectors.toList());
            case SAD:
                return IntStream.rangeClosed(60, 100)
                        .filter(n -> n % 10 == 0)
                        .boxed()
                        .collect(Collectors.toList());
            default:
                return Collections.emptyList();

        }
    }
}
