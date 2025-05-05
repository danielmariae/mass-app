package br.org.massapp.api.controller;

import java.util.List;

import br.org.massapp.api.dto.request.ClerigoDTO;
import br.org.massapp.api.dto.response.ClerigoResponseDTO;
import br.org.massapp.api.service.ClerigoService;
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

@Path("/clerigos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClerigoController {
    @Inject
    ClerigoService service;

    @POST
    public Response criarClerigo(@Valid ClerigoDTO dto) {
        ClerigoResponseDTO response = service.create(dto);
        return Response.status(201).entity(response).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarClerigo(
        @PathParam("id") Long id,
        @Valid ClerigoDTO dto
    ) {
        ClerigoResponseDTO response = service.update(id, dto);
        return Response.ok(response).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletarClerigo(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
    
    @GET
    @Path("/{id}")
    public Response getClerigoById(@PathParam("id") Long id){
        ClerigoResponseDTO response = service.getUsuarioById(id);
        return Response.ok(response).build();
    }

    @GET
    public Response getClerigos(){
        List<ClerigoResponseDTO> response = service.getAllUsers();
        return Response.ok(response).build();
    }
}
