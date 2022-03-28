import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    private final EntityManagerFactory factory;

    public DbHelper(EntityManagerFactory factory) {
        this.factory = factory;
    }

    List<Artist> getAllArtists() {
        return new ArrayList<>();
    }

    List<Album> getAllAlbums() {
        return new ArrayList<>();
    }

    Album getAlbumForId(Integer albumId) {
        return null;
    }

    Track getTrackForId(Integer trackId) {
        return null;
    }

    GenreStats getGenreStatsForId(Integer id) {
        return null;
    }

    Artist getArtistForId(Integer artistId) {
        return null;
    }

    Playlist getPlaylistForId(Integer id) {
        return null;
    }

    List<GenreAndCount> getAllGenresWithCounts() {
        return new ArrayList<>();
    }

    List<Playlist> getAllPlaylists() {
        return new ArrayList<>();
    }
}
