package lt.vu.persistence;

import lt.vu.entities.Language;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Alternative
public class LanguagesDAOImplSlow implements LanguagesDAO
{
    @Inject
    private EntityManager em;

    public List<Language> loadAll()
    {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        return em.createNamedQuery("Language.findAll", Language.class).getResultList();
    }

    public Language findOne(Integer id)
    {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        return em.find(Language.class, id);
    }

    public void persist(Language language)
    {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        this.em.persist(language);
    }

    public void update(Language language)
    {
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        this.em.merge(language);
    }
}

