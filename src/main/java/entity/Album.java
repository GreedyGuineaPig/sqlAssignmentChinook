package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Album {

    private Integer id;

    private String title;

    private Artist artist;

    private List<Track> tracks = new ArrayList<>();

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }
    public Artist getArtist() {
        return artist;
    }

    void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
