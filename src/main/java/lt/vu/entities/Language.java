package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "select a from Language as a")
})
@Table(name = "LANGUAGE")
@Getter @Setter
public class Language implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 64)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "languages")
    private List<Person> subscribers = new ArrayList<>();

    public Language() {}

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) &&
        Objects.equals(name, language.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }
}
