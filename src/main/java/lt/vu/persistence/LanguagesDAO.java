package lt.vu.persistence;

import lt.vu.entities.Language;
import java.util.List;

public interface LanguagesDAO
{
    List<Language> loadAll();

    Language findOne(Integer id);

    void persist(Language language);

    void update(Language language);
}