package com.example.dit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestService {
    @GET
    public Response testEndpoint() {
        return Response.ok("RESTEasy is working!").build();
    }
}
