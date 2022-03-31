package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "media_types")
public class MediaType {
    @Id
    @Column(name = "MediaTypeId")
    private int id;

    @Column(name = "Name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
