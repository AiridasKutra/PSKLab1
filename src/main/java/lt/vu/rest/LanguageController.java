package lt.vu.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Language;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.LanguagesDAO;
import lt.vu.rest.dto.LanguageDTO;

@ApplicationScoped
@Getter @Setter
@Path("/languages")
public class LanguageController
{
    @Inject
    private LanguagesDAO languagesDAO;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @LoggedInvocation
    public Response getAll()
    {
        List<LanguageDTO> users = languagesDAO.loadAll().stream().map(LanguageDTO::new).collect(Collectors.toList());
        return Response.ok(users).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id)
    {
        Language language = languagesDAO.findOne(id);
        if (language != null)
        {
            LanguageDTO user = new LanguageDTO(language);
            return Response.ok(user).build();
        }
        else {
            return Response.noContent().build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response post(LanguageDTO language)
    {
        try
        {
            if (language.getName() == null || language.getName().isEmpty())
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            Language newLanguage = new Language();
            newLanguage.setName(language.getName());
            languagesDAO.persist(newLanguage);
            return Response.ok().build();
        }
        catch (OptimisticLockException ole)
        {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response put(@PathParam("id") final Integer id, LanguageDTO language)
    {
        try
        {
            Language existingLanguage = languagesDAO.findOne(id);
            if (existingLanguage == null)
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingLanguage.setName(language.getName());
            languagesDAO.update(existingLanguage);
            return Response.ok().build();
        }
        catch (OptimisticLockException ole)
        {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}