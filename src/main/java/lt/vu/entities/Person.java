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
    @NamedQuery(name = "Person.findAll", query = "select p from Person as p")
})
@Table(name = "PERSON")
@Getter @Setter
public class Person implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 80)
    @Column(name = "FULL_NAME")
    private String fullName;

    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "person")
    private List<Image> images = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "language_subscriptions",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages = new ArrayList<>();

    public Person() {}

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(fullName, person.fullName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, fullName);
    }
}
