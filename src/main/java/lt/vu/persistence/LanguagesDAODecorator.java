package lt.vu.persistence;

import lt.vu.entities.Language;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;

@Decorator
public abstract class LanguagesDAODecorator implements LanguagesDAO
{
    @Inject
    @Delegate
    @Any
    LanguagesDAO languagesDAO;

    public List<Language> loadAll()
    {
        List<Language> languages = languagesDAO.loadAll();
        languages.stream().forEach(language -> {
            if (language.getSubscribers().size() == 0)
            {
                language.setName(language.getName() + " (Unpopular)");
            }
        });
        return languages;
    }
}
