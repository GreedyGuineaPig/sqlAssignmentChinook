package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="playlists")
public class Playlist {
    @Id
    @Column(name = "PlaylistId")
    private int id;

    @Column(name = "Name")
    private String name;

    @JoinTable(name = "playlist_track",
            joinColumns =  {
            @JoinColumn(name="PlaylistId", referencedColumnName = "playlistId")
    }, inverseJoinColumns = {
            @JoinColumn(name = "TrackId", referencedColumnName = "TrackId")
    }
    )
    @ManyToMany
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
