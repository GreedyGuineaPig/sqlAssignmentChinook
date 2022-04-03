import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        List<Object[]> resultList = em.createQuery(
                "select count(distinct t.id), count(distinct t.album), count(distinct t.album.artist) " +
                        "from Track t fetch all properties where t.genre = :genre").setParameter("genre", genre).getResultList();
        ArrayList<Long> list = new ArrayList();
        for(Object obj: resultList.get(0)){
            list.add((Long) obj);
        }
        return new GenreStats(genre, list.get(2), list.get(1), list.get(0));
    }

    Artist getArtistForId(Integer artistId) {
        EntityManager em = factory.createEntityManager();
        return em.find(Artist.class, artistId);
    }

    Playlist getPlaylistForId(Integer id) {
        return null;
    }

    List<GenreAndCount> getAllGenresWithCounts() {
        EntityManager em = factory.createEntityManager();
        List<GenreAndCount> resultList = em.createQuery("select new entity.GenreAndCount(t.genre.id, t.genre.name, count(t.name)) from Track as t fetch all properties group by t.genre order by count(t.name) desc ").getResultList();
//        select g.Name, count(t.name) from Tracks t JOIN genres g on t.GenreId = g.GenreId GROUP BY g.name
        return resultList;
    }

    List<Playlist> getAllPlaylists() {
        return new ArrayList<>();
    }
}
