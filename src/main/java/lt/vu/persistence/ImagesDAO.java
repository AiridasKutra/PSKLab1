package lt.vu.persistence;

import lt.vu.entities.Image;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ImagesDAO {

    @Inject
    private EntityManager em;

    public void persist(Image image)
    {
        this.em.persist(image);
    }

    public Image findOne(Integer id)
    {
        return em.find(Image.class, id);
    }
}
