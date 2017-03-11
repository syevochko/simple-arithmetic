package com.google.evochko;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@ApplicationPath("/SimpleArithmetic")
@Path("/api")
public class SimpleArithmeticsRestService {
    @GET
    @Path("/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRestService(InputStream inputStream) {
        String result = "SimpleArithmeticsRestService successfully1 started..";
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/calc/{x1}/{x2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(@PathParam("x1") String x1, @PathParam("x2") String x2) {
        System.out.println("x1 = " + x1);
        String result = "{'x1':" + x1 + ",'x2':" + x2 + "}";
        return Response.status(200).entity(result).build();
    }
}
