package backend.controllers;

import backend.data.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("dashboard")
public class DashboardController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> lista() {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Usuario get(@PathParam("id") int id) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Usuario usuario) {
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Usuario usuario) {
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") int id) {
        return null;
    }

}
