package lt.vu.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Language;

@Getter @Setter
public class LanguageDTO
{
    public Integer id;

    public String name;

    public LanguageDTO()
    { }

    public LanguageDTO(Language language)
    {
        id = language.getId();
        name = language.getName();
    }
}
