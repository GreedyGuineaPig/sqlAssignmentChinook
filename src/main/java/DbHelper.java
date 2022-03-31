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
        EntityManager em = factory.createEntityManager();
        return em.find(Track.class, trackId);
    }

    GenreStats getGenreStatsForId(Integer id) {
        EntityManager em = factory.createEntityManager();
        Genre genre = em.find(Genre.class, id);
//        List resultList = em.createQuery(
//                "select count(distinct t.id), count(distinct t.album), count(distinct t.album.artist) " +
//                        "from Track t fetch all properties where t.genre = :genre").setParameter("genre", genre).getResultList();
        long numOfTrack = (long) em.createQuery("select count(distinct t.id) from Track t where t.genre = :genre").setParameter("genre", genre).getSingleResult();
        long numOfAlbum = (long) em.createQuery("select count(distinct al.id) from Album al join al.tracks as t where t.genre = :genre").setParameter("genre", genre).getSingleResult();
        long numOfArtist = (long) em.createQuery("select count(distinct ar.id) from Track t join t.album as al join al.artist as ar where t.genre = :genre").setParameter("genre", genre).getSingleResult();
        return new GenreStats(genre, numOfArtist, numOfAlbum, numOfTrack);
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
