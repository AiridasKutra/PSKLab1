package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Person;
import lt.vu.persistence.LanguagesDAO;
import lt.vu.entities.Language;
import lt.vu.persistence.PersonsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@ViewScoped
@Named
public class LanguageList implements Serializable
{
    @Inject
    private LanguagesDAO languagesDAO;

    @Inject
    private PersonsDAO personsDAO;

    @Getter
    private List<Language> allLanguages;

    public List<Language> getUnusedLanguages(Person person)
    {

        return allLanguages.stream().filter(l -> !l.getSubscribers().contains(person)).collect(Collectors.toList());
    }

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
