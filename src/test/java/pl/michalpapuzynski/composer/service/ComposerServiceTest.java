package pl.michalpapuzynski.composer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.michalpapuzynski.composer.model.*;

import java.util.List;

public class ComposerServiceTest {

    // TODO Przetestuj niepoprawną liczbę akordów

    ComposerService composerService = new ComposerService();

    @Test
    public void livelyMoodTest() {
        // given
        List<Chord> chords = List.of(
                new Chord(Variant.MAJOR, KeyNote.C),
                new Chord(Variant.MAJOR, KeyNote.F),
                new Chord(Variant.MAJOR, KeyNote.Cis),
                new Chord(Variant.MINOR, KeyNote.G));
        SongConcept songConcept = new SongConcept(chords, 160);
        SongRequirements songRequirements = new SongRequirements(Mood.LIVELY, 4);

        // when
        SongConcept song = composerService.composeSong(songConcept, songRequirements);

        // then
        Assertions.assertEquals(25, song.getMinorPercentage());
        Assertions.assertTrue(song.getTempo() <= 160
                && song.getTempo() >= 120 && song.getTempo() % 10 == 0);

    }

    @Test
    public void popMoodTest() {
        // given
        List<Chord> chords = List.of(
                new Chord(Variant.MAJOR, KeyNote.C),
                new Chord(Variant.MAJOR, KeyNote.F),
                new Chord(Variant.MINOR, KeyNote.Cis),
                new Chord(Variant.MINOR, KeyNote.G));
        SongConcept songConcept = new SongConcept(chords, 120);
        SongRequirements songRequirements = new SongRequirements(Mood.POP, 4);

        // when
        SongConcept song = composerService.composeSong(songConcept, songRequirements);

        // then
        Assertions.assertEquals(50, song.getMinorPercentage());
        Assertions.assertTrue(song.getTempo() <= 140
                && song.getTempo() >= 120 && song.getTempo() % 10 == 0);

    }

    @Test
    public void calmMoodTest() {
        // given
        List<Chord> chords = List.of(
                new Chord(Variant.MAJOR, KeyNote.C),
                new Chord(Variant.MAJOR, KeyNote.F),
                new Chord(Variant.MAJOR, KeyNote.B),
                new Chord(Variant.MINOR, KeyNote.G));
        SongConcept songConcept = new SongConcept(chords, 100);
        SongRequirements songRequirements = new SongRequirements(Mood.CALM, 4);

        // when
        SongConcept song = composerService.composeSong(songConcept, songRequirements);

        // then
        Assertions.assertEquals(25, song.getMinorPercentage());
        Assertions.assertTrue(song.getTempo() <= 120
                && song.getTempo() >= 100 && song.getTempo() % 5 == 0);

    }

    @Test
    public void sadMoodTest() {
        // given
        List<Chord> chords = List.of(
                new Chord(Variant.MAJOR, KeyNote.C),
                new Chord(Variant.MINOR, KeyNote.F),
                new Chord(Variant.MINOR, KeyNote.Cis),
                new Chord(Variant.MINOR, KeyNote.G));
        SongConcept songConcept = new SongConcept(chords, 60);
        SongRequirements songRequirements = new SongRequirements(Mood.SAD, 4);

        // when
        SongConcept song = composerService.composeSong(songConcept, songRequirements);

        // then
        Assertions.assertEquals(75, song.getMinorPercentage());
        Assertions.assertTrue(song.getTempo() <= 100
                && song.getTempo() >= 60 && song.getTempo() % 5 == 0);

    }




}
