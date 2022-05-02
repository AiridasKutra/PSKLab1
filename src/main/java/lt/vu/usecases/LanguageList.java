package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.persistence.LanguagesDAO;
import lt.vu.entities.Language;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class LanguageList {

    @Inject
    private LanguagesDAO languagesDAO;

    @Getter
    private List<Language> allLanguages;

    @PostConstruct
    public void init()
    {
        loadAllLanguages();
    }

    private void loadAllLanguages()
    {
        this.allLanguages = languagesDAO.loadAll();
    }
}
