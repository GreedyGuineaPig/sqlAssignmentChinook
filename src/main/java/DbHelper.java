import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    private final EntityManagerFactory factory;

    public DbHelper(EntityManagerFactory factory) {
        this.factory = factory;
    }

    List<Artist> getAllArtists()  {
        EntityManager em = factory.createEntityManager();
        return em.createQuery("from Artist a inner join fetch a.albums album order by a.name", Artist.class).getResultList();
    }

    List<Album> getAllAlbums() {
        EntityManager em = factory.createEntityManager();
        return em.createQuery("from Album a inner join fetch a.artist album order by a.title", Album.class).getResultList();
    }

    Album getAlbumForId(Integer albumId) {
        EntityManager em = factory.createEntityManager();
        return em.find(Album.class, albumId);
    }

    Track getTrackForId(Integer trackId) {
        return null;
    }

    GenreStats getGenreStatsForId(Integer id) {
        return null;
    }

    Artist getArtistForId(Integer artistId) {
        EntityManager em = factory.createEntityManager();
        return em.find(Artist.class, artistId);
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
