package lt.vu.persistence;

import lt.vu.entities.Image;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class ImagesDAOSlow extends ImagesDAO
{
    @Override
    public void persist(Image image)
    {
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        super.persist(image);
    }
}
