package com.google.evochko;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;


@Path("/SimpleArithmetic")
public class SimpleArithmeticsRestService {
    @GET
    @Path("/api/verify")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyRestService(InputStream inputStream) {
        String result = "SimpleArithmeticsRestService successfully started..";
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/api/calc/{x1}/{x2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculate(@PathParam("x1") String x1, @PathParam("x2") String x2) {
        String result = "{'x1':" + x1 + ",'x2':" + x2 + "}\n";
        return Response.status(200).entity(result).build();
    }
}
