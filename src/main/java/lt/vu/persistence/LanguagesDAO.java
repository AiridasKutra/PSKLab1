package lt.vu.persistence;

import lt.vu.entities.Language;
import lt.vu.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LanguagesDAO {

    @Inject
    private EntityManager em;

    public List<Language> loadAll()
    {
        return em.createNamedQuery("Language.findAll", Language.class).getResultList();
    }

    public Language findOne(Integer id)
    {
        return em.find(Language.class, id);
    }
}
