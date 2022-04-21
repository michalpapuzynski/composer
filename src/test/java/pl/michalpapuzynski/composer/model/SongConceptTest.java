package pl.michalpapuzynski.composer.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SongConceptTest {

    @Test
    public void testPercentage() {
        // given
        SongConcept songConcept = new SongConcept(List.of(
                new Chord(Variant.MAJOR,KeyNote.C),
                new Chord(Variant.MAJOR,KeyNote.C),
                new Chord(Variant.MAJOR,KeyNote.C),
                new Chord(Variant.MINOR,KeyNote.C)), 130);

        // expect

        Assertions.assertEquals(25.0, songConcept.getMinorPercentage());


    }

}