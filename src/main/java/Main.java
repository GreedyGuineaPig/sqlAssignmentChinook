import spark.ModelAndView;
import spark.Request;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static final ThymeleafTemplateEngine engine = new ThymeleafTemplateEngine();
    private static DbHelper dbHelper = new DbHelper(factory);

    public static void main(String[] args) {
        startRoutes();
        System.out.println("Serving at http://localhost:4567/");
    }

    private static void startRoutes() {
        Spark.get("/", (req, res) -> render("index", new HashMap<>()));
        Spark.get("/artist", (req, res) -> render("artistList", Map.of("artists", dbHelper.getAllArtists())));
        Spark.get("/album", (req, res) -> render("albumList", Map.of("albums", dbHelper.getAllAlbums())));
        Spark.get("/genre", (req, res) -> render("genreList", Map.of("genreCounts", dbHelper.getAllGenresWithCounts())));
        Spark.get("/playlist", (req, res) -> render("playlistList", Map.of("playlists", dbHelper.getAllPlaylists())));
        Spark.get("/playlist/:playlistId", (req, res) -> render("playlistDetails", Map.of("playlist", dbHelper.getPlaylistForId(getIntParam(req, "playlistId")))));
        Spark.get("/album/:albumId", (req, res) -> render("albumDetails", Map.of("album", dbHelper.getAlbumForId(getIntParam(req, "albumId")))));
        Spark.get("/artist/:artistId", (req, res) -> render("artistDetails", Map.of("artist", dbHelper.getArtistForId(getIntParam(req, "artistId")))));
        Spark.get("/track/:trackId", (req, res) -> render("trackDetails", Map.of("track", dbHelper.getTrackForId(getIntParam(req, "trackId")))));
        Spark.get("/genre/:genreId", (req, res) -> render("genreDetails", Map.of("genreStats", dbHelper.getGenreStatsForId(getIntParam(req, "genreId")))));

    }

    private static Integer getIntParam(Request req, String param) {
        return Integer.valueOf(req.params(param));
    }

    private static Object render(String template, Map<String, Object> map) {
        return engine.render(new ModelAndView(map, template));
    }

}
