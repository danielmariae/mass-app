package br.org.massapp.api.controller;

import java.util.List;

import br.org.massapp.api.dto.request.ParoquiaDTO;
import br.org.massapp.api.dto.response.ParoquiaResponseDTO;
import br.org.massapp.api.service.ParoquiaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/paroquias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParoquiaController {
    @Inject 
    ParoquiaService service;
    
    @POST
    public Response criarParoquia(@Valid ParoquiaDTO dto) {
        ParoquiaResponseDTO response = service.create(dto);
        return Response.status(201).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarParoquia(
        @PathParam("id") Long id,
        @Valid ParoquiaDTO dto
    ) {
        ParoquiaResponseDTO response = service.update(id, dto);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarParoquia(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
    @GET
    @Path("/{id}")
    public Response getParoquiaById(@PathParam("id") Long id){
        ParoquiaResponseDTO response = service.getUsuarioById(id);
        return Response.ok(response).build();
    }

    @GET
    public Response getParoquias(){
        List<ParoquiaResponseDTO> response = service.getAllUsers();
        return Response.ok(response).build();
    }

}
