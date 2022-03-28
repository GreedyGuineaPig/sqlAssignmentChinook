package entity;

public class GenreStats {
    public final Genre genre;
    public final long artists;
    public final long albums;
    public final long tracks;

    public GenreStats(Genre genre, long artists, long albums, long tracks) {
        this.genre = genre;
        this.artists = artists;
        this.albums = albums;
        this.tracks = tracks;
    }
}
