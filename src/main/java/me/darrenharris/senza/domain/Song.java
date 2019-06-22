package me.darrenharris.senza.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * song
 */
@XmlRootElement
public class Song {

    private String artist;
    private String title;

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}