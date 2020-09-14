package backend.controllers;

import backend.data.Transparencia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("transparencia")
public class TransparenciaController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transparencia> listaTransparencia() {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Transparencia get(@PathParam("id") int id) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Transparencia transparencia) {
        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Transparencia transparencia) {
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") int id) {
        return null;
    }

}
