package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "GenreId")
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
