package backend.controllers;

import backend.data.Usuario;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Usuario get(@PathParam("id") int id) {
        return null;
    }

}
