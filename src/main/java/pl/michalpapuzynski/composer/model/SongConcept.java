package pl.michalpapuzynski.composer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class SongConcept {

    private List<Chord> chords;
    private int tempo;

    public double getMinorPercentage() {

        double minorCount = 0.0;

        for (Chord chord : chords) {

            if (chord.getVariant() == Variant.MINOR) {
                minorCount++;
            }

        }

        return (minorCount / chords.size()) * 100;

    }

}
