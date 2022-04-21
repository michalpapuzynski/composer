package pl.michalpapuzynski.composer.controller;

import org.springframework.stereotype.Controller;
import pl.michalpapuzynski.composer.model.AcceptanceStatus;
import pl.michalpapuzynski.composer.model.SongConcept;
import pl.michalpapuzynski.composer.model.SongRequirements;
import pl.michalpapuzynski.composer.service.ComposerService;

@Controller
public class ComposerController {

    private ComposerService service;

    public SongConcept composeSong(SongConcept songConcept, SongRequirements requirements) {
        return service.composeSong(songConcept, requirements);
    }

    public AcceptanceStatus acceptSong(SongConcept songConcept, String songName) {
        return service.acceptSong(songConcept, songName);
    }

}
