package me.darrenharris.senza.service;

import java.util.ArrayList;
import java.util.List;

import me.darrenharris.senza.domain.Song;

/**
 * SongService
 */
public class SongService {
    

    public List<Song> findStartsWith(String expString) {
        List<Song> results = new ArrayList<>();

        Song song1 = new Song();
        song1.setArtist("Pink Floyd");
        song1.setTitle("Another brick in the wall");
        results.add(song1);

        Song song2 = new Song();
        song2.setArtist("Paul Weller");
        song2.setTitle("English rose");
        results.add(song2);

        return results;
    }

    public SongService() {
    }
}