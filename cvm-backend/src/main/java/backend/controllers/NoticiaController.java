package backend.controllers;

import backend.data.Noticia;
import backend.data.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("noticia")
public class NoticiaController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Noticia> listaNoticia() {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Noticia get(@PathParam("id") int id) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Noticia create(Usuario usuario) {
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Noticia update(Usuario usuario) {
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") int id) {
        return null;
    }

}
