package pl.michalpapuzynski.composer.service;

import org.springframework.stereotype.Service;
import pl.michalpapuzynski.composer.model.*;

import java.util.List;

import static pl.michalpapuzynski.composer.model.Mood.LIVELY;

@Service
public class ComposerService {

    public SongConcept composeSong(SongConcept songConcept, SongRequirements requirements) {
        if (songConcept.getMinorPercentage() <= requirements.getMaxMinorPercentage()
        && requirements.getTempoInterval().contains(songConcept.getTempo())){
            return songConcept;
        } else {
            return rearrange(songConcept, requirements);
        }

    }

    private SongConcept rearrange(SongConcept songConcept, SongRequirements songRequirements) {
        List<Chord> chords;
        switch (songRequirements.getMood()) {
            case LIVELY:
                chords = List.of(
                        new Chord(Variant.MAJOR, KeyNote.C),
                        new Chord(Variant.MAJOR, KeyNote.F),
                        new Chord(Variant.MAJOR, KeyNote.Cis),
                        new Chord(Variant.MINOR, KeyNote.G));
                songConcept.setTempo(160);
                break;
            case POP:
                chords = List.of(
                        new Chord(Variant.MAJOR, KeyNote.C),
                        new Chord(Variant.MAJOR, KeyNote.F),
                        new Chord(Variant.MINOR, KeyNote.Cis),
                        new Chord(Variant.MINOR, KeyNote.G));
                songConcept.setTempo(120);
                break;
            case CALM:
                chords = List.of(
                        new Chord(Variant.MAJOR, KeyNote.C),
                        new Chord(Variant.MAJOR, KeyNote.F),
                        new Chord(Variant.MAJOR, KeyNote.B),
                        new Chord(Variant.MINOR, KeyNote.G));
                songConcept.setTempo(100);
                break;
            case SAD:
                chords = List.of(
                        new Chord(Variant.MAJOR, KeyNote.C),
                        new Chord(Variant.MINOR, KeyNote.F),
                        new Chord(Variant.MINOR, KeyNote.Cis),
                        new Chord(Variant.MINOR, KeyNote.G));
                songConcept.setTempo(60);
                break;
            default:
                chords = List.of(
                        new Chord(Variant.MAJOR, KeyNote.C),
                        new Chord(Variant.MAJOR, KeyNote.F),
                        new Chord(Variant.MAJOR, KeyNote.Cis),
                        new Chord(Variant.MINOR, KeyNote.G));
                songConcept.setTempo(130);
                break;

        }
        songConcept.setChords(chords);


        return songConcept;
    }

    public AcceptanceStatus acceptSong(SongConcept songConcept, String songName) {
        return null; // TODO implement
    }
}
