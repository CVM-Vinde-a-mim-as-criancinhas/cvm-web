package backend.controllers;

import backend.data.Agenda;
import backend.data.Usuario;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
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
//    public List<Agenda> listaAgenda() {
    public Agenda listaAgenda() {
        List<Agenda> agendas = new ArrayList<>();
        Agenda agenda = new Agenda();
        agenda.setDescricaoEvento("teste");
        agenda.setId(1);

//        agendas.add(agenda);
//        return agendas;
        return agenda;
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
