package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @Column(name = "AlbumId")
    private Integer id;

    @Column(name = "Title")
    private String title;

    @JoinColumn(name = "ArtistId")
    @ManyToOne
    private Artist artist;

    @OneToMany(mappedBy = "album")
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
