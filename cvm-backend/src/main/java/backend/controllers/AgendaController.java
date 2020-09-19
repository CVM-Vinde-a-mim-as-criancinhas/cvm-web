package backend.controllers;

import backend.data.Agenda;
import backend.data.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("agenda")
public class AgendaController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Agenda agenda) {
        System.out.println(agenda);
        System.out.println(agenda);
        System.out.println(agenda);
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Agenda> listaAgenda() {
        List<Agenda> agendas = new ArrayList<>();

        return agendas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Usuario get(@PathParam("id") int id) {
        return null;
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Agenda agenda) {
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response delete(@PathParam("id") int id) {
        return null;
    }

}
