package entity;

public class GenreAndCount {
    public final int genreId;
    public final String genreName;
    public final long count;

    public GenreAndCount(int genreId, String genreName, long count) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.count = count;
    }
}
