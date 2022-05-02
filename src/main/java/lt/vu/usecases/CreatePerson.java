package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.persistence.PersonsDAO;
import lt.vu.entities.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class CreatePerson
{

    @Inject
    private PersonsDAO personsDAO;

    @Getter @Setter
    private Person personToCreate = new Person();

    @PostConstruct
    public void init() {}

    @Transactional
    public String createPerson()
    {
        personsDAO.persist(personToCreate);
        return "personDetails.xhtml?personId=" + this.personToCreate.getId() + "&faces-redirect=true";
    }
}
