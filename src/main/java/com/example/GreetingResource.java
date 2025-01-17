package com.example;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    OracleService oracleService;
    @Inject
    Iw_web_userService iw_web_userService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Assalamualaikum Ukhti";
    }

    @Path("/oracle")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getVersion() {
        return oracleService.getDatabaseVersion();
    }

    @Path("/user-management")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Iw_web_user> getAllUsers() {
        return iw_web_userService.listAllIw_web_user();
    }
}
