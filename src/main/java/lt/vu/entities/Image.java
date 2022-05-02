package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "select a from Person as a")
})
@Table(name = "IMAGE")
@Getter @Setter
public class Image implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 256)
    @Column(name="URL")
    private String url;

    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    private Person person;

    public Image() {}

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
        Objects.equals(url, image.url);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, url);
    }
}
