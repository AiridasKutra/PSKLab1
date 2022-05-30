package lt.vu.usecases;

import lt.vu.entities.Language;
import lt.vu.entities.Person;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.LanguagesDAO;
import lt.vu.persistence.PersonsDAO;
import lt.vu.services.LanguageSuggester;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class SuggestLanguage implements Serializable
{
    @Inject
    LanguageSuggester languageSuggester;

    @Inject
    PersonsDAO personsDAO;

    @Inject
    LanguagesDAO languagesDAO;

    private CompletableFuture<String> languageSuggestionTask = null;

    @LoggedInvocation
    public String suggest()
    {
        Map<String, String> requestParameters =
        FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String personIdString = requestParameters.get("personId");

        Person thisPerson = personsDAO.findOne(Integer.parseInt(personIdString));
        List<Language> allLanguages = languagesDAO.loadAll();

        languageSuggestionTask = CompletableFuture.supplyAsync(() -> /*"Bruh"*/
            languageSuggester.suggest(
                thisPerson,
                allLanguages
            )
        );

        return  "/personDetails.xhtml?faces-redirect=true&personId=" + personIdString;
    }

    public boolean executing()
    {
        return languageSuggestionTask != null && !languageSuggestionTask.isDone();
    }

    public String suggestedLanguage() throws ExecutionException, InterruptedException
    {
        if (languageSuggestionTask == null)
            return "";
        else if (!languageSuggestionTask.isDone())
            return "Executing...";
        else
            return "Suggested language: " + languageSuggestionTask.get();
    }
}