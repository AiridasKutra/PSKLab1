package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Image;
import lt.vu.persistence.ImagesDAO;
import lt.vu.persistence.LanguagesDAO;
import lt.vu.persistence.PersonsDAO;
import lt.vu.entities.Person;
import lt.vu.entities.Language;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class PersonDisplay {

    @Getter
    private Person person;

    @Getter @Setter
    private Integer languageToAdd;

    @Getter @Setter
    private String imageToAdd;

    @Inject
    private PersonsDAO personsDAO;

    @Inject
    private LanguagesDAO languagesDAO;

    @Inject
    private ImagesDAO imagesDAO;

    @PostConstruct
    private void init()
    {
        System.out.println("INIT PersonDisplay");
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer personId = Integer.parseInt(requestParameters.get("personId"));
        person = personsDAO.findOne(personId);
        languageToAdd = 1;
    }

    @Transactional
    public String addLanguage()
    {
        Language language = languagesDAO.findOne(languageToAdd);
        if (language != null)
        {
            person.getLanguages().add(language);
        }
        personsDAO.update(person);
        return "personDetails.xhtml?personId=" + person.getId() + "&faces-redirect=true";
    }

    @Transactional
    public String addImage()
    {
        System.out.println("Adding " + imageToAdd);
        Image image = new Image();
        image.setUrl(imageToAdd);
        image.setPerson(person);
        imagesDAO.persist(image);
        return "personDetails.xhtml?personId=" + person.getId() + "&faces-redirect=true";
    }
}
