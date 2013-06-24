package com.sgrailways.resteasy.controllers;

import com.google.inject.Inject;
import com.sgrailways.resteasy.model.Developer;
import com.sgrailways.resteasy.service.DevelopersService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/developers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DevelopersController {
    private DevelopersService developersService;

    @Inject
    public DevelopersController(DevelopersService developersService) {
        this.developersService = developersService;
    }

    //GET /resteasy-hey-world/api/locomotives
    @GET
    public Response list() {
        try {
            List<Developer> developers = developersService.list();
            return Response
                    .status(Response.Status.OK)
                    .entity(developers)
                    .build();

        } catch (SQLException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

    //GET /resteasy-hey-world/api/locomotives/count
    @GET
    @Path("/count")
    public Response count() {
        try {
            int count = developersService.count();
            return Response
                    .status(Response.Status.OK)
                    .entity(count)
                    .build();

        } catch (SQLException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }
    }

    @POST
    @Path("/new")
    public Response newDeveloper(Developer developer) {
        try {
            Developer createdDeveloper = developersService.create(developer);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(createdDeveloper)
                    .build();
        } catch (SQLException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        }

    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteDeveloper(@PathParam("id") int id) {
        try {
            developersService.delete(id);
            return Response
                    .status(Response.Status.OK)
                    .build();
        } catch (SQLException e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();

        }

    }

    @PUT
    @Path("/update")
    public Response updateDeveloper(Developer developer) {
        try {
            developersService.update(developer);
            return Response
                    .status(Response.Status.OK)
                    .build();

        } catch (SQLException e){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();


        }


    }
}
