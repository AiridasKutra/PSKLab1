package lt.vu.persistence;

import lt.vu.entities.Language;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Alternative
public class LanguagesDAOImpl implements LanguagesDAO
{
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

    public void persist(Language language)
    {
        this.em.persist(language);
    }

    public void update(Language language)
    {
        this.em.merge(language);
    }
}
