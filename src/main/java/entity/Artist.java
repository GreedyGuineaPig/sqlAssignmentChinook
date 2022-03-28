package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Artist {
    private Integer id;

    private String name;

    private List<Album> albums = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
