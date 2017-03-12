package com.google.evochko;

import com.google.evochko.exceptions.AppException;
import com.google.evochko.exceptions.InvalidExpression;
import com.google.evochko.exceptions.InvalidParameters;
import com.google.evochko.model.Message;
import com.google.evochko.model.Status;
import com.sun.jersey.spi.resource.Singleton;
import matchParser.MatchParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationPath("/SimpleArithmetic")
@Path("/api")
@Singleton
public class SimpleArithmeticRestService extends Application {
    private static final Logger logger = LogManager.getLogger(SimpleArithmeticRestService.class);
    private String mathExpression;

    public SimpleArithmeticRestService()    {
        mathExpression = "(x1+x2)/2";
        logger.info("start service with expression: " + mathExpression);
    }

    @GET
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON)
    public Message verifyRestService(InputStream inputStream) {
        return new Message(Status.OK, "SimpleArithmeticRestService successfully started...", 0);
    }


    @GET
    @Path("/calc")
    @Produces(MediaType.APPLICATION_JSON)
    public Message calculate(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        Map<String, Double> params = new HashMap<>(queryParams.size());
        List<String> invalidKeys = new ArrayList<>(queryParams.size());
        MatchParser calculation = new MatchParser();
        Double result;

        for (Map.Entry<String, List<String>> e : queryParams.entrySet()) {
            try {
                String key = e.getKey().toLowerCase();
                Double val = Double.valueOf(e.getValue().get(0));
                params.put(key, val);
                calculation.setVariable(key, val);

            } catch (NumberFormatException ex) {
                invalidKeys.add(e.getKey() + "=" + e.getValue().get(0));
            }
        }

        try {
            if (!invalidKeys.isEmpty()) {
                throw new InvalidParameters(invalidKeys);
            }

            try {
                result = calculation.Parse(mathExpression);
            } catch (Exception e) {
                throw new InvalidExpression("Invalid expression: " + mathExpression);
            }

            Message m = new Message(Status.OK, mathExpression + " << " + params + " = ", result);
            logger.info(m.getMessage() + m.getResult());
            return m;

        } catch (AppException ae) {
            logger.catching(ae);
            return ae.getExceptionMessage();
        }
    }

    @GET
    @Path("/expression/{expression}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message setExpression(@PathParam("expression") String expression) {
        if (expression == null || expression.length() == 0) {
            logger.warn("Setting the expression failed - it was empty");
            return new Message(Status.ERROR, "invalid expression", 0);
        }

        mathExpression = expression;
        Message m = new Message(Status.OK, "expression set to: " + mathExpression, 0);
        logger.info(m.getMessage());
        return m;
    }
}
