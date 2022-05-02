package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.PersonMapper;
import lt.vu.mybatis.model.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class PersonsDisplayMB
{
    @Inject
    private PersonMapper personMapper;

    @Getter
    private List<Person> allPersons;

    @PostConstruct
    public void init()
    {
        loadAllPersons();
    }

    private void loadAllPersons()
    {
        allPersons = personMapper.selectAll();
    }
}
