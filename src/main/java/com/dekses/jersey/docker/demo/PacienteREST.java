/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tpaclate file, choose Tools | Tpaclates
 * and open the tpaclate in the editor.
 */
package com.dekses.jersey.docker.demo;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author white
 */
@Path("/paciente")
public class PacienteREST {
    // URI:
    // /contextPath/servletPath/paciente
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Paciente> getPacientes_JSON() {
        List<Paciente> pacientes = PacienteDAO.getAllPacientes();
        return pacientes;
    }
    
    // URI:
    // /contextPath/servletPath/paciente
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Paciente addPaciente(Paciente pac) {
        return PacienteDAO.addPaciente(pac);
    }
    
    // URI:
    // /contextPath/servletPath/paciente
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Paciente updatePaciente(Paciente pac) {
        return PacienteDAO.updatePaciente(pac);
    }
 
    @DELETE
    @Path("/{pacNo}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deletePaciente(@PathParam("pacNo") String pacNo) {
        PacienteDAO.deletePaciente(pacNo);
    }
}
