package backend.controllers;

import backend.data.Agenda;
import backend.data.Noticia;
import backend.data.Transparencia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dashboard")
public class DashboardController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Agenda> listaAgenda() {
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Noticia> listaNoticia() {
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transparencia> listaTransparencia() {
        return null;
    }

}
