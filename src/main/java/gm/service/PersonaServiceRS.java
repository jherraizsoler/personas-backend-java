/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.service;

import gm.data.PersonaDAO;
import gm.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;

/**
 *
 * @author herra
 */
@Stateless
@Path("/personas")
public class PersonaServiceRS {

    @Inject
    private PersonaDAO personaDAO;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas() {
        List<Persona> personas = personaDAO.encontrarTodasPersonas();
        System.out.println("Personas encontradas: " + personas);
        return personas;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") // Hace referencia al path: /personas/{id}, ej. /personas/1
    public Persona encontrarPersona(@PathParam("id") int id) {
        Persona persona = personaDAO.encontrarPersona(new Persona(id));
        System.out.println("Persona encontrada: " + persona);
        return persona;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona) {
        personaDAO.insertarPersona(persona);
        System.out.println("Persona agregada: " + persona);
        return persona;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
        Persona persona = personaDAO.encontrarPersona(new Persona(id));
        if (persona != null && persona.getIdPersona() == personaModificada.getIdPersona()) {
            personaDAO.actualizarPersona(personaModificada);
            System.out.println("Persona modificada: " + personaModificada);
            return Response.ok().entity(personaModificada).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id) {
        Persona persona = personaDAO.encontrarPersona(new Persona(id));

        personaDAO.eliminarPersona(persona);
        System.out.println("Persona eliminada con el id: " + id);
        return Response.ok().build();

    }

}
