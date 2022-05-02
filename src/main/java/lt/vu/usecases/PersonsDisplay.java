package lt.vu.usecases;

import lombok.Getter;
import lt.vu.persistence.PersonsDAO;
import lt.vu.entities.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class PersonsDisplay
{
    @Inject
    private PersonsDAO personsDAO;

    @Getter
    private List<Person> allPersons;

    @PostConstruct
    public void init()
    {
        loadAllPersons();
    }

    private void loadAllPersons()
    {
        this.allPersons = personsDAO.loadAll();
    }
}
