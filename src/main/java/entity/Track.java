package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @Column(name = "TrackId")
    private int id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genre;

    @Transient
    private List<Playlist> playlists = new ArrayList<>();

    @Column(name = "milliseconds")
    private int millis;  // The track duration in milliseconds

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum() {
        return album;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getMillis() {
        return millis;
    }

    // Returns the song duration (up to the second) in a human-readable form
    public String getDuration() {
        int seconds = millis / 1000;
        int mins = seconds / 60;
        int hours = mins / 60;
        mins = mins % 60;
        seconds = seconds % 60;
        return (includeAsNeeded("hr", hours) +
                includeAsNeeded("min", mins) +
                includeAsNeeded("sec", seconds)).trim();
    }

    private String includeAsNeeded(String base, int amount) {
        if (amount == 0) return "";
        if (amount == 1) return amount + base + " ";
        return amount + base + "s ";
    }
}
