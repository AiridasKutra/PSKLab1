package lt.vu.persistence;

import lt.vu.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonsDAO {

    @Inject
    private EntityManager em;

    public List<Person> loadAll()
    {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    public void persist(Person person)
    {
        em.persist(person);
    }

    public Person findOne(Integer id)
    {
        return em.find(Person.class, id);
    }

    public Person update(Person person)
    {
        return em.merge(person);
    }
}
