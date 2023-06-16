package se.andreas.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import se.andreas.calc.CalcService;
import se.andreas.calc.model.CalcRes;

@Path("calc")
public class CalcRs {

    @Inject
    private CalcService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CalcRes calc(@QueryParam("query") String query) {
        return service.calc(query);
    }
}
