package com.google.evochko;

import com.google.evochko.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationPath("/SimpleArithmetic")
@Path("/api")
public class SimpleArithmeticRestService extends Application {
    @GET
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON)
    public Message verifyRestService(InputStream inputStream) {
        return new Message(0, "OK", "SimpleArithmeticRestService successfully started..", 0);
    }

    @GET
    @Path("/calc")
    @Produces(MediaType.APPLICATION_JSON)
    public Message calculate(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        Map<String, Double> params = new HashMap<>(queryParams.size());
        List<String> invalidKeys = new ArrayList<>(queryParams.size());

        for (Map.Entry<String, List<String>> e : queryParams.entrySet()) {
            try {
                Double val = Double.valueOf( e.getValue().get(0));
                params.put(e.getKey().toLowerCase(), val);
            } catch (NumberFormatException ex)  {
                invalidKeys.add(e.getKey() + "=" + e.getValue().get(0));
            }
        }

        if (!invalidKeys.isEmpty())  {
            return new Message(1000, "ERROR", "Invalid numbers in " + invalidKeys, 0);
        }
        return new Message(0, "OK", "calculation result is " + params, 0);
    }
}
