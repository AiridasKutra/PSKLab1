package lt.vu.services;

import lt.vu.entities.Language;
import lt.vu.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@ApplicationScoped
public class LanguageSuggester implements Serializable
{
    public String suggest(Person person, List<Language> languages)
    {
        try { Thread.sleep(5000); } catch (InterruptedException ex) {}
        List<Language> candidateLanguages = languages.stream().filter(language -> {
            if (language.getSubscribers().size() > 0)
                return false;
            if (language.getSubscribers().contains(person))
                return false;
            return true;
        }).collect(Collectors.toList());
        if (candidateLanguages.isEmpty())
            return "No languages to suggest..";

        return candidateLanguages.get(ThreadLocalRandom.current().nextInt(candidateLanguages.size())).getName();
    }
}
