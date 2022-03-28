package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;

    private String name;

    private List<Track> tracks = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
